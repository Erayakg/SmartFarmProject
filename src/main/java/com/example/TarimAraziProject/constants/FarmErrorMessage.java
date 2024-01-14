package com.example.TarimAraziProject.constants;

import com.example.TarimAraziProject.exceptions.BaseErrorMessage;

public enum FarmErrorMessage implements BaseErrorMessage {

    NOT_FOUND("Farm not found!"),
    BAD_REQUEST("request is null"),
    SAVE_ERROR("Farm save error"),
    NOT_READY_ERROR("The farm is not ready to harvest "),
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
