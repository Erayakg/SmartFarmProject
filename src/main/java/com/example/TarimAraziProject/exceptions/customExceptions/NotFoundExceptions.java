package com.example.TarimAraziProject.exceptions.customExceptions;

import com.example.TarimAraziProject.exceptions.BaseErrorMessage;
import com.example.TarimAraziProject.exceptions.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundExceptions extends BusinessException {
    public NotFoundExceptions(BaseErrorMessage baseErrorMessage) {
        super(baseErrorMessage);
    }
}
