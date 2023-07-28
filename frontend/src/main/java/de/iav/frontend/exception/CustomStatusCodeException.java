package de.iav.frontend.exception;

public class CustomStatusCodeException extends RuntimeException {
    public CustomStatusCodeException(String s) {
        super(s);
    }
}
