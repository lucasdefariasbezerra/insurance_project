package com.audsat.insurance.model;

import jakarta.persistence.*;

@Entity
@Table(name = "car_driver")
public class CarDrive {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="driver_id", nullable = false)
    private Driver driver;

    @ManyToOne
    @JoinColumn(name="car_id", nullable = false)
    private Car car;

    @Column(name = "is_main_driver")
    private Boolean isMainDriver;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Boolean getMainDriver() {
        return isMainDriver;
    }

    public void setMainDriver(Boolean mainDriver) {
        isMainDriver = mainDriver;
    }
}
