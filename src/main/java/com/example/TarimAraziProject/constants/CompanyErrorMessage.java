package com.example.TarimAraziProject.constants;

import com.example.TarimAraziProject.exceptions.BaseErrorMessage;

public enum CompanyErrorMessage implements BaseErrorMessage {
    NOT_FOUND("Company not found!"),
    BAD_REQUEST("Request is null "),
    SAVE_ERROR("Company save error"),
    ;

    private String message;

    CompanyErrorMessage(String message) {
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
