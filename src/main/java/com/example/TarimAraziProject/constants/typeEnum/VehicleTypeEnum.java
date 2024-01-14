package com.example.TarimAraziProject.constants.typeEnum;

public enum VehicleTypeEnum {
    VEHICLE_TYPE_FERTILIZATION("Fertilization Vehicle",1),
    VEHICLE_TYPE_PLOWING("Plowing Vehicle",2);

    String typeString;
    Integer typeInt;

    VehicleTypeEnum(String typeString, Integer typeInt) {
        this.typeString = typeString;
        this.typeInt = typeInt;
    }

    public String getTypeString() {
        return typeString;
    }

    @Override
    public String toString() {
        return "VehicleTypeEnum{" +
                "typeString='" + typeString + '\'' +
                ", typeInt=" + typeInt +
                '}';
    }
}
