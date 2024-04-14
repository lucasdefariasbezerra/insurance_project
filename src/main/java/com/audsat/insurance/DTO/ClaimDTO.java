package com.audsat.insurance.DTO;

public class ClaimDTO {
    private String driverDocument;
    private Integer carId;

    public ClaimDTO() {
    }

    public String getDriverDocument() {
        return driverDocument;
    }

    public void setDriverDocument(String driverDocument) {
        this.driverDocument = driverDocument;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }
}
