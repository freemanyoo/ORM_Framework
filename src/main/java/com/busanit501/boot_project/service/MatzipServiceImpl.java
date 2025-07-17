package com.busanit501.boot_project.service;

import com.busanit501.boot_project.dto.PageRequestDTO;
import com.busanit501.boot_project.dto.PageResponseDTO;
import com.busanit501.boot_project.dto.matzip.MatzipErrorResponseDTO;
import com.busanit501.boot_project.dto.matzip.MatzipResponseDTO;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class MatzipServiceImpl implements MatzipService {

    @Value("${busan.api.key}")
    private String busanApiKey;

    @Value("${busan.api.url}")
    private String busanApiUrl;

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final XmlMapper xmlMapper = new XmlMapper();

    {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    @Override
    public PageResponseDTO<MatzipResponseDTO.Item> getMatzipList(PageRequestDTO pageRequestDTO) {
        String apiUrl = String.format("%s/getgmgfoodinfo?serviceKey=%s&numOfRows=%d&pageNo=%d&resultType=json",
                busanApiUrl, busanApiKey, pageRequestDTO.getSize(), pageRequestDTO.getPage());

        log.info("Calling Busan API: " + apiUrl);

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, "application/json");
        headers.set(HttpHeaders.USER_AGENT, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<String> rawResponseEntity = restTemplate.exchange(
                    apiUrl, HttpMethod.GET, entity, String.class);
            String rawResponse = rawResponseEntity.getBody();

            log.info("Raw Busan API Response: " + rawResponse);

            try {
                MatzipResponseDTO response = objectMapper.readValue(rawResponse, MatzipResponseDTO.class);
                log.info("Deserialized Busan API Response: " + response);

                if (response != null && response.getResponse() != null &&
                        response.getResponse().getBody() != null &&
                        response.getResponse().getBody().getItems() != null &&
                        response.getResponse().getBody().getItems().getItem() != null) {

                    List<MatzipResponseDTO.Item> items = response.getResponse().getBody().getItems().getItem();
                    int totalCount = response.getResponse().getBody().getTotalCount();

                    return PageResponseDTO.<MatzipResponseDTO.Item>withAll()
                            .pageRequestDTO(pageRequestDTO)
                            .dtoList(items)
                            .total(totalCount)
                            .build();
                }
            } catch (Exception jsonException) {
                log.warn("Failed to parse response as JSON, attempting to parse as XML.", jsonException);
                try {
                    MatzipErrorResponseDTO errorResponse = xmlMapper.readValue(rawResponse, MatzipErrorResponseDTO.class);
                    log.error("Received XML error from API: " + errorResponse.getCmmMsgHeader().getReturnAuthMsg());
                } catch (Exception xmlException) {
                    log.error("Failed to parse response as XML as well.", xmlException);
                }
            }
        } catch (Exception e) {
            log.error("Error calling Busan API: " + e.getMessage(), e);
        }

        return PageResponseDTO.<MatzipResponseDTO.Item>withAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(Collections.emptyList())
                .total(0)
                .build();
    }
}