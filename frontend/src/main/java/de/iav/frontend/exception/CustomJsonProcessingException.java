package de.iav.frontend.exception;

import com.fasterxml.jackson.core.JsonProcessingException;

public class CustomJsonProcessingException extends RuntimeException {
    public CustomJsonProcessingException(String s, JsonProcessingException e) {
        super(s, e);
    }
}
