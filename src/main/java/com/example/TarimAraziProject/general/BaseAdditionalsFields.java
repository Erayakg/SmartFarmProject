package com.example.TarimAraziProject.general;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Embeddable
@Getter
@Setter
public class BaseAdditionalsFields {

    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private Long createdBy;
    private Long updatedBy;
}
