package com.example.TarimAraziProject.constants.typeEnum;

public enum CropTypeEnum {
    CROP_WHEAT("CROP TYPE IS WHEAT",1),
    CROP_RICE("CROP TYPE IS RICE",2),
    CROP_CORN("CROP TYPE IS CORN",3);

    String typeString;
    Integer typeInt;

    CropTypeEnum(String typeString, Integer typeInt) {
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
