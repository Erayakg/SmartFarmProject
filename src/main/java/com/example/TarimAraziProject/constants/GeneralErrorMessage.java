package com.example.TarimAraziProject.constants;

import com.example.TarimAraziProject.exceptions.BaseErrorMessage;

public enum GeneralErrorMessage  implements BaseErrorMessage {

    SAVE_FARM_TO_COMPANY_ERROR("Farm save to Company error!"),
    SAVE_VEHICLE_TO_COMPANY("Vehicle save to Company error!"),
    SAVE_USER_TO_FARM("Userr save to company Error"),
    UNDEFINED_TASK_TYPE("invalid task type")
    ;

    private String message;

    GeneralErrorMessage(String message) {
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
