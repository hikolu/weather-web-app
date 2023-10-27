package com.hikolu.weather.exception;

import java.io.Serial;

public class CityNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -8457837444456553029L;

    public CityNotFoundException(String message) {
        super(message);
    }

    public CityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CityNotFoundException(Throwable cause) {
        super(cause);
    }
}
