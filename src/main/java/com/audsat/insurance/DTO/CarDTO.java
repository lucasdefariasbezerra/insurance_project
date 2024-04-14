package com.audsat.insurance.DTO;

public class CarDTO {
    private Integer carId;
    private String model;
    private String manufacturer;
    private String year;
    private Double fipeValue;

    public CarDTO() {
    }

    public CarDTO(Integer carId, String model, String manufacturer, String year, Double fipeValue) {
        this.carId = carId;
        this.model = model;
        this.manufacturer = manufacturer;
        this.year = year;
        this.fipeValue = fipeValue;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Double getFipeValue() {
        return fipeValue;
    }

    public void setFipeValue(Double fipeValue) {
        this.fipeValue = fipeValue;
    }
}
