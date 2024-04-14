package com.audsat.insurance.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ClaimDTO {
    private String driverDocument;
    private Integer carId;

    @JsonFormat(pattern="dd/MM/yyyy")
    private Date eventDate;

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

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }
}
