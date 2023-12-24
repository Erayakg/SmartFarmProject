package com.example.TarimAraziProject.exceptions;

public enum FarmErrorMessage implements BaseErrorMessage{

    NOT_FOUND("Farm not found!"),
    BAD_REQUEST("request is null"),
    SAVE_ERROR("Farm save error")
    ;

    private String message;

   FarmErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
