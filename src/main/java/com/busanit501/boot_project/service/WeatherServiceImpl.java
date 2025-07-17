package com.busanit501.boot_project.service;

import com.busanit501.boot_project.dto.weather.WeatherResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;

@Service
@RequiredArgsConstructor
@Log4j2
public class WeatherServiceImpl implements WeatherService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public WeatherResponseDTO getCurrentWeather(double latitude, double longitude) {
        String url = String.format("https://api.open-meteo.com/v1/forecast?latitude=%f&longitude=%f&current_weather=true", latitude, longitude);

        log.info("Open-Meteo API 호출 중: " + url);

        try {
            WeatherResponseDTO response = restTemplate.getForObject(url, WeatherResponseDTO.class);
            log.info("Open-Meteo API 응답 성공: " + response);
            return response;
        } catch (HttpClientErrorException e) {
            log.error("API 호출 중 클라이언트 오류 발생: " + e.getStatusCode() + " - " + e.getResponseBodyAsString(), e);
        } catch (ResourceAccessException e) {
            log.error("API 호출 중 네트워크 연결 오류 발생: " + e.getMessage(), e);
        } catch (Exception e) {
            log.error("API 호출 중 알 수 없는 오류 발생: " + e.getMessage(), e);
        }
        return null;
    }
}