package com.busanit501.boot_project.service;

import com.busanit501.boot_project.domain.Matzip;
import com.busanit501.boot_project.dto.matzip.MatzipResponseDTO;
import com.busanit501.boot_project.repository.MatzipRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class MatzipDataCollectorService {

    private final MatzipRepository matzipRepository;

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

    // 애플리케이션 시작 시 데이터 수집 (초기 로딩)
    @PostConstruct
    public void collectAndSaveMatzipData() {
        log.info("Starting Matzip data collection...");
        int pageNo = 1;
        int numOfRows = 100; // 한 번에 가져올 데이터 수 (API 제한 확인 필요)
        boolean hasMoreData = true;

        while (hasMoreData) {
            URI uri = UriComponentsBuilder
                    .fromUriString(busanApiUrl)
                    .path("/getgmgfoodinfo")
                    .queryParam("serviceKey", busanApiKey)
                    .queryParam("numOfRows", numOfRows)
                    .queryParam("pageNo", pageNo)
                    .queryParam("resultType", "json")
                    .build(true)
                    .toUri();

            log.info("Calling Busan API for data collection: " + uri);

            HttpHeaders headers = new HttpHeaders();
            headers.set(HttpHeaders.ACCEPT, "application/json");
            headers.set(HttpHeaders.USER_AGENT, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36");
            HttpEntity<String> entity = new HttpEntity<>(headers);

            try {
                ResponseEntity<String> rawResponseEntity = restTemplate.exchange(
                        uri, HttpMethod.GET, entity, String.class);
                String rawResponse = rawResponseEntity.getBody();

                MatzipResponseDTO response = objectMapper.readValue(rawResponse, MatzipResponseDTO.class);

                if (response != null && response.getResponse() != null &&
                        response.getResponse().getBody() != null &&
                        response.getResponse().getBody().getItems() != null &&
                        response.getResponse().getBody().getItems().getItem() != null) {

                    List<MatzipResponseDTO.Item> apiItems = response.getResponse().getBody().getItems().getItem();

                    if (apiItems.isEmpty()) {
                        hasMoreData = false;
                    } else {
                        List<Matzip> matzipEntities = apiItems.stream().map(item -> Matzip.builder()
                                .ucSeq((long) item.getUcSeq())
                                .mainTitle(item.getMainTitle())
                                .addr1(item.getAddr1())
                                .cntctTel(item.getCntctTel())
                                .itemcntnts(item.getItemCntnts())
                                .usageDay(item.getUsageDayWeekAndTime())
                                .mainImgN(item.getMainImgNormal())
                                .mainImgT(item.getMainImgThumb())
                                .lat(String.valueOf(item.getLat()))
                                .lng(String.valueOf(item.getLng()))
                                .build()
                        ).collect(Collectors.toList());

                        matzipRepository.saveAll(matzipEntities);
                        log.info("Saved {} Matzip items from page {}", matzipEntities.size(), pageNo);
                        pageNo++;
                    }
                } else {
                    hasMoreData = false;
                }
            } catch (Exception e) {
                log.error("Error collecting Matzip data from API: " + e.getMessage(), e);
                hasMoreData = false; // 오류 발생 시 중단
            }
        }
        log.info("Matzip data collection finished.");
    }
}
