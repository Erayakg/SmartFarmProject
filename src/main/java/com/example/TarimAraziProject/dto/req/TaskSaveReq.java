package com.example.TarimAraziProject.dto.req;

import lombok.Data;

@Data
public class TaskSaveReq {

    private Long vehicleId;
    private Long CompanyId;
    private Long farmId;
    private int TaskType;

}
