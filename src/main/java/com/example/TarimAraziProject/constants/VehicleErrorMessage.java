package com.example.TarimAraziProject.constants;

import com.example.TarimAraziProject.exceptions.BaseErrorMessage;

public enum VehicleErrorMessage implements BaseErrorMessage {


    NOT_FOUND("Vehicle not found!"),
    BAD_REQUEST("request is null"),
    SAVE_ERROR("Vehicle save error")
            ;

    private String message;

    VehicleErrorMessage(String message) {
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
