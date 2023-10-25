package com.hikolu.weather.entity;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

public class CurrentWeather implements Serializable {

    // give this class serialVersionUID
    @Serial
    private static final long serialVersionUID = 5252695057303669171L;

    // define fields for everything that is used in current-weather.html
    private String description;
    private BigDecimal temperature;
    private BigDecimal feelsLike;
    private BigDecimal windSpeed;

    // define constructors
    public CurrentWeather() {
    }

    public CurrentWeather(String description, BigDecimal temperature, BigDecimal feelsLike, BigDecimal windSpeed) {
        this.description = description;
        this.temperature = temperature;
        this.feelsLike = feelsLike;
        this.windSpeed = windSpeed;
    }

    // define getters and setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getTemperature() {
        return temperature;
    }

    public void setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
    }

    public BigDecimal getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(BigDecimal feelsLike) {
        this.feelsLike = feelsLike;
    }

    public BigDecimal getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(BigDecimal windSpeed) {
        this.windSpeed = windSpeed;
    }

    // generate equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CurrentWeather that = (CurrentWeather) o;

        if (getDescription() != null ? !getDescription().equals(that.getDescription()) : that.getDescription() != null)
            return false;
        if (getTemperature() != null ? !getTemperature().equals(that.getTemperature()) : that.getTemperature() != null)
            return false;
        if (getFeelsLike() != null ? !getFeelsLike().equals(that.getFeelsLike()) : that.getFeelsLike() != null)
            return false;
        return getWindSpeed() != null ? getWindSpeed().equals(that.getWindSpeed()) : that.getWindSpeed() == null;
    }

    // generate hashCode
    @Override
    public int hashCode() {
        int result = getDescription() != null ? getDescription().hashCode() : 0;
        result = 31 * result + (getTemperature() != null ? getTemperature().hashCode() : 0);
        result = 31 * result + (getFeelsLike() != null ? getFeelsLike().hashCode() : 0);
        result = 31 * result + (getWindSpeed() != null ? getWindSpeed().hashCode() : 0);
        return result;
    }
}
