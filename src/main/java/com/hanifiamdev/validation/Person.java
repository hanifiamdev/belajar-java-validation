package com.hanifiamdev.validation;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Person {

    @NotBlank(message = "first name can not blank")
    @Size(max = 20, message = "first name length max must 20 characters")
    private String firstName;

    @NotBlank(message = "last name can not blank")
    @Size(max = 20, message = "last name length max must 20 characters")
    private String lastName;

    @NotNull(message = "address can not null")
    @Valid
    private Address address;

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public void sayHello(@NotBlank(message = "name can not blank") String name){
        System.out.println("Hello " + name + ", my name is " + firstName);
    }

    @NotBlank(message = "full name can not blank")
    public String fullName() {
        return firstName + " " + lastName;
    }
}
