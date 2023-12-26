package com.example.TarimAraziProject.exceptions.customExceptions;

import com.example.TarimAraziProject.exceptions.BaseErrorMessage;
import com.example.TarimAraziProject.exceptions.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundExceptions extends BusinessException {

    public UserNotFoundExceptions(BaseErrorMessage baseErrorMessage) {
        super(baseErrorMessage);
    }
}
