package com.busanit501.boot_project.controller;

import com.busanit501.boot_project.dto.weather.WeatherResponseDTO;
import com.busanit501.boot_project.service.WeatherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/weather")
@RequiredArgsConstructor
@Log4j2
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/current")
    public String getCurrentWeather(@RequestParam(defaultValue = "35.1796") double latitude,
                                  @RequestParam(defaultValue = "129.0756") double longitude,
                                  Model model) {
        log.info("날씨 정보 요청: 위도=" + latitude + ", 경도=" + longitude);

        WeatherResponseDTO weatherData = weatherService.getCurrentWeather(latitude, longitude);

        model.addAttribute("weather", weatherData.getCurrentWeather());
        return "weather/current";
    }

    public static String getWeatherIcon(Integer weatherCode) {
        if (weatherCode == null) {
            return "❓";
        }
        return switch (weatherCode) {
            case 0 -> "☀️";
            case 1, 2, 3 -> "☁️";
            case 45, 48 -> "🌫️";
            case 51, 53, 55 -> "🌧️";
            case 56, 57 -> "🌧️";
            case 61, 63, 65 -> "☔";
            case 66, 67 -> "☔";
            case 71, 73, 75 -> "🌨️";
            case 77 -> "❄️";
            case 80, 81, 82 -> "⛈️";
            case 85, 86 -> "🌨️";
            case 95 -> "⚡";
            case 96, 99 -> "⚡";
            default -> "❓";
        };
    }

    public static String getWeatherDescription(Integer weatherCode) {
        if (weatherCode == null) {
            return "알 수 없음";
        }
        return switch (weatherCode) {
            case 0 -> "맑음";
            case 1 -> "대체로 맑음";
            case 2 -> "부분적으로 흐림";
            case 3 -> "흐림";
            case 45, 48 -> "안개";
            case 51, 53, 55 -> "이슬비";
            case 56, 57 -> "얼어붙는 이슬비";
            case 61, 63, 65 -> "비";
            case 66, 67 -> "얼어붙는 비";
            case 71, 73, 75 -> "눈";
            case 77 -> "싸락눈";
            case 80, 81, 82 -> "소나기";
            case 85, 86 -> "눈 소나기";
            case 95 -> "천둥번개";
            case 96, 99 -> "천둥번개와 우박";
            default -> "알 수 없음";
        };
    }
}
