package com.example.TarimAraziProject.exceptions.customExceptions;

import com.example.TarimAraziProject.exceptions.BaseErrorMessage;
import com.example.TarimAraziProject.exceptions.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotReadyFarmToHarvestError extends BusinessException {
    public NotReadyFarmToHarvestError(BaseErrorMessage baseErrorMessage) {
        super(baseErrorMessage);
    }
}
