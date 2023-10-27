package com.hikolu.weather.controller;

import com.hikolu.weather.entity.CurrentWeather;
import com.hikolu.weather.service.LiveWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CurrencyEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
public class WeatherController {

    private LiveWeatherService liveWeatherService;

    @Autowired
    public WeatherController(LiveWeatherService liveWeatherService) {
        this.liveWeatherService = liveWeatherService;
    }

    @GetMapping("/api/current-weather")
    public String getCurrentWeather(Model model, @RequestParam String city, @RequestParam String country) {

        // get an instance of CurrentWeather from service
        CurrentWeather currentWeather = liveWeatherService.getCurrentWeather(city, country);

        // add currentWeather to the model
        model.addAttribute("currentWeather", currentWeather);

        // return the html page name
        return "current-weather";
    }
}
