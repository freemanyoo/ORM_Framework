package com.busanit501.boot_project.service;

import com.busanit501.boot_project.dto.weather.WeatherResponseDTO;

public interface WeatherService {
    WeatherResponseDTO getCurrentWeather(double latitude, double longitude);
}