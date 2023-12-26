package com.example.TarimAraziProject.constants;

import com.example.TarimAraziProject.exceptions.BaseErrorMessage;

public enum UserErrorMessage implements BaseErrorMessage {

    NOT_FOUND("User not found!"),
    BAD_REQUEST("request is null"),
    SAVE_ERROR("User save error");

    private String message;

    UserErrorMessage(String message) {
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
