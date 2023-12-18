package com.example.TarimAraziProject.constants;

import com.example.TarimAraziProject.exceptions.BaseErrorMessage;

public class CustomerErrorMessageConstants  implements BaseErrorMessage {
    public static final String VALUE_NOT_FOUND = "Değer bulunamadı.";

    @Override
    public String getMessage() {
        return VALUE_NOT_FOUND;
    }
}
