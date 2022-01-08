package com.hanifiamdev.validation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ContainerDataTest extends AbstractValidatorTest{

    @Test
    void testContainerData() {

        Person person = new Person();
        person.setFirstName("Hanif");
        person.setLastName("Amrullah");
        person.setAddress(new Address());
        person.getAddress().setCity("Pemalang");
        person.getAddress().setCountry("Indonesia");
        person.getAddress().setStreet("Bougenville");

        person.setHobbies(new ArrayList<>());
        person.getHobbies().add("");
        person.getHobbies().add(" ");
        person.getHobbies().add("Badminton");
        
        validate(person);
    }
}
