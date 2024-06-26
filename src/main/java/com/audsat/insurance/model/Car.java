package com.audsat.insurance.model;

import jakarta.persistence.*;

@Entity
@Table(name = "car")
public class Car {

    @Id
    private Integer id;

    @Column(name = "model")
    private String model;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "year")
    private String year;

    @Column(name = "fipe_value")
    private Double fipeValue;


    public Integer getId() {
        return id;
    }

    public Car() {
    }

    public Car(Integer id, String model, String manufacturer, String year, Double fipeValue) {
        this.id = id;
        this.model = model;
        this.manufacturer = manufacturer;
        this.year = year;
        this.fipeValue = fipeValue;
    }

    public void setId(Integer id) {
        this.id = id;
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
