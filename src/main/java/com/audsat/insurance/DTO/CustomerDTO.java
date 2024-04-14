package com.audsat.insurance.DTO;

public class CustomerDTO  extends DriverDTO {
    private String name;

    public CustomerDTO(String name, String document, String birthDate) {
        super(document, birthDate);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
