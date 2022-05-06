package dev.danielwilliam.springboothandson.response;

import lombok.Getter;

@Getter
public class ErrorResponse extends Exception {
    private String errorMessage;

    public ErrorResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
