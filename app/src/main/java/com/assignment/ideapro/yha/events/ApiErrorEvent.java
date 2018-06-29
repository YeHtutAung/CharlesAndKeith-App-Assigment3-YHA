package com.assignment.ideapro.yha.events;

public class ApiErrorEvent {
    private String errorMessage = null;

    public ApiErrorEvent(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
