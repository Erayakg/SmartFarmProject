package com.example.TarimAraziProject.general;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RestResponse<T> implements Serializable {
    private T data;
    private LocalDateTime responseDate;
    private Boolean success;
    private String message;

    public RestResponse(T data, Boolean success) {
        this.data = data;
        this.success = success;
        this.responseDate=LocalDateTime.now();

    }

    public static <T> RestResponse<T> of(T t){
        return new RestResponse(t, true);
    }
    public static <T> RestResponse<T> error(T t){
        return new RestResponse(t, false);
    }


}
