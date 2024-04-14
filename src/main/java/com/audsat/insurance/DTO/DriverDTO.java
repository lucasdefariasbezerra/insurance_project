package com.audsat.insurance.DTO;

public class DriverDTO {
    private String document;
    private String birthDate;


    public DriverDTO() {
    }

    public DriverDTO(String document, String birthDate) {
        this.document = document;
        this.birthDate = birthDate;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
