package com.example.tradeservice.util.exception;

import lombok.Getter;
import org.slf4j.helpers.MessageFormatter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This exception is meant to be thrown by the controller to produce a response for the client.
 * <p> It is meant to be thrown if you try to perform operations with a rest api.
 * <p> The response code produced is 400
 */

@Getter
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException{
    private final String info;
    private final String resourceName;
    private final String fieldName;
    private final Object fieldValue;

    public BadRequestException(final String info, final Class<?> resourceName, final String fieldName,
                               final Object fieldValue) {
        this.info = info;
        this.resourceName = resourceName.getSimpleName();
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    @Override
    public String getMessage() {
        return MessageFormatter.arrayFormat("Bad request in resource:'{}' for field:'{}' with value:'{}'",
                new Object[]{info, resourceName, fieldName, fieldValue}).getMessage();
    }
}
