package com.example.tradeservice.util.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This exception is meant to be thrown by the controller to produce a response for the client.
 * <p> It is meant to be thrown if you try to perform operations with a rest api.
 * <p> The response code produced is 404
 */

@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public NotFoundException(final String resourceName, final String fieldName, final Object fieldValue) {
        super(String.format("%s not found with %s=%s", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException() {

    }
}
