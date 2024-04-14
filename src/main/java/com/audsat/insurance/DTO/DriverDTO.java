package com.audsat.insurance.DTO;

public class DriverDTO {
    private String document;
    private String birthDate;
    private Boolean isMain;


    public DriverDTO() {
    }

    public DriverDTO(String document, String birthDate) {
        this.document = document;
        this.birthDate = birthDate;
    }

    public DriverDTO(String document) {
        this.document = document;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Boolean getIsMain() {
        return isMain;
    }

    public void setMain(Boolean main) {
        isMain = main;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
