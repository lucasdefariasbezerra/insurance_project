package com.audsat.insurance.DTO;

import java.util.List;

public class InsuranceDTO {

    private Boolean isActive;
    private CustomerDTO customer;
    private CarDTO car;
    private List<DriverDTO> driverList;
    private List<ClaimDTO> claimList;

    public InsuranceDTO() {
    }

    public InsuranceDTO(Boolean isActive, CustomerDTO customer, CarDTO car, List<DriverDTO> driverList, List<ClaimDTO> claimList) {
        this.isActive = isActive;
        this.customer = customer;
        this.car = car;
        this.driverList = driverList;
        this.claimList = claimList;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public CarDTO getCar() {
        return car;
    }

    public void setCar(CarDTO car) {
        this.car = car;
    }

    public List<DriverDTO> getDriverList() {
        return driverList;
    }

    public void setDriverList(List<DriverDTO> driverList) {
        this.driverList = driverList;
    }

    public List<ClaimDTO> getClaimList() {
        return claimList;
    }

    public void setClaimList(List<ClaimDTO> claimList) {
        this.claimList = claimList;
    }
}
