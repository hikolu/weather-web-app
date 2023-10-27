package com.hikolu.weather.exception;

public class WeatherErrorResponse {

    private boolean success;
    private int status;
    private String message;

    public WeatherErrorResponse() {
    }

    public WeatherErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public WeatherErrorResponse(boolean success, int status, String message) {
        this.success = success;
        this.status = status;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
