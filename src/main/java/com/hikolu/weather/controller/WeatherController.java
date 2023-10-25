package com.hikolu.weather.controller;

import com.hikolu.weather.entity.CurrentWeather;
import org.springframework.beans.propertyeditors.CurrencyEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;

@Controller
public class WeatherController {

    @GetMapping("/api/current-weather")
    public String getCurrentWeather(Model model) {

        // create an instance of CurrentWeather
        CurrentWeather currentWeather = new CurrentWeather("Clear", BigDecimal.ONE, BigDecimal.ZERO, BigDecimal.TEN);

        // add currentWeather to the model
        model.addAttribute("currentWeather", currentWeather);

        // return the html page name
        return "current-weather";
    }
}
