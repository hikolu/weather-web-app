package com.hikolu.weather.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hikolu.weather.entity.CurrentWeather;
import com.hikolu.weather.exception.RestTemplateResponseErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.math.BigDecimal;
import java.net.URI;

@Service
public class LiveWeatherService {

    // define field for our api url
    private static final String WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather?q={city},{country}&appid={key}&units=metric";

//     set the value for apiKey from application.properties
    @Value("${api.openweathermap.key}")
    private String apiKey;

    // define fields for RestTemplate and ObjectMapper to get custom fields from the response
    private RestTemplate restTemplate;
    private ObjectMapper objectMapper;

    public LiveWeatherService(RestTemplateBuilder restTemplateBuilder, ObjectMapper objectMapper) {

        this.restTemplate = restTemplateBuilder.errorHandler(new RestTemplateResponseErrorHandler()).build();
        this.objectMapper = objectMapper;
    }

    // define constructor
    public CurrentWeather getCurrentWeather(String city, String country) {

        // expand the WEATHER_URL to set {city}, {country}, {apiKey} in it
        URI url = new UriTemplate(WEATHER_URL).expand(city, country, apiKey);

        // create the responseEntity from the GET call to the API
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        // return the converted ResponseEntity from String to CurrentWeather object
        return convert(response);
    }

    private CurrentWeather convert(ResponseEntity<String> response) {

        try {
            JsonNode root = objectMapper.readTree(response.getBody());

            return new CurrentWeather(root.path("weather").get(0).path("main").asText(),
                    BigDecimal.valueOf(root.path("main").path("temp").asDouble()),
                    BigDecimal.valueOf(root.path("main").path("feels_like").asDouble()),
                    BigDecimal.valueOf(root.path("wind").path("speed").asDouble()));
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error parsing JSON", e);
        }
    }
}
