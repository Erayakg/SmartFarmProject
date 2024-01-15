package com.example.TarimAraziProject.constants;

import com.example.TarimAraziProject.exceptions.BaseErrorMessage;

public enum GeneralErrorMessage  implements BaseErrorMessage {

    SAVE_FARM_TO_COMPANY_ERROR("Farm save to Company error!"),
    SAVE_VEHICLE_TO_COMPANY("Vehicle save to Company error!"),
    SAVE_USER_TO_FARM("User save to company Error"),
    NOT_READY_HARVEST("Farm is not ready harvest because not planted yet"),
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
