package com.hanifiamdev.validation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Address {

    @Size(max = 20, message = "street length max must 20 characters")
    @NotBlank(message = "street length max must 20 characters")
    private String street;

    @Size(max = 20, message = "city length max must 20 characters")
    @NotBlank(message = "city length max must 20 characters")
    private String city;

    @NotNull(message = "country can not blank")
    private String country;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
