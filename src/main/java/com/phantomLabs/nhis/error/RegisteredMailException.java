package com.phantomLabs.nhis.error;

public class RegisteredMailException extends Exception{
    public RegisteredMailException() {
        super();
    }

    public RegisteredMailException(String message) {
        super(message);
    }

    public RegisteredMailException(String message, Throwable cause) {
        super(message, cause);
    }

    public RegisteredMailException(Throwable cause) {
        super(cause);
    }

    protected RegisteredMailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
