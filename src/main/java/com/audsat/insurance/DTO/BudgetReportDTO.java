package com.audsat.insurance.DTO;

public class BudgetReportDTO {
    private String customerName;
    private String carModel;
    private Double fipeValue;
    private Double insurancePrice;

    public BudgetReportDTO() {
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Double getFipeValue() {
        return fipeValue;
    }

    public void setFipeValue(Double fipeValue) {
        this.fipeValue = fipeValue;
    }

    public Double getInsurancePrice() {
        return insurancePrice;
    }

    public void setInsurancePrice(Double insurancePrice) {
        this.insurancePrice = insurancePrice;
    }
}
