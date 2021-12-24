package com.hanifiamdev.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class ConstraintViolationTest {

    private ValidatorFactory validatorFactory;

    private Validator validator;

    @BeforeEach
    void setUp() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterEach
    void tearDown() {
        validatorFactory.close();
    }

    @Test
    void testValidationFailedNotBlank() {

        Person person = new Person();

        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        Assertions.assertEquals(2, violations.size()); // check total validasi apakah ada 2

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println("====== Validation =========");
            System.out.println("Message : " + violation.getMessage()); //mendapatkan message errornya apa
            System.out.println("Bean : " + violation.getLeafBean()); //mendapatkan object fieldnya itu ada dimana
            System.out.println("Constraint : " + violation.getConstraintDescriptor().getAnnotation()); //anotation apa yang menjadiakan ini eror
            System.out.println("Path : " + violation.getPropertyPath()); // field apa sih erornya
            System.out.println("Invalid Value : " + violation.getInvalidValue());// value apa sih yang dianggap tidak valid
            System.out.println("===========================\n");
        }
    }

    @Test
    void testValidationFailedNotSize() {

        Person person = new Person();
        person.setFirstName("wkwkwkwkwkwkwkwkwkwkwkwkwkwkwwkwkwkwkwkwk"); // > 20 character
        person.setLastName("wkwkwkwkwkwkwkwkwkwkwkwkwkwkwwkwkwkwkwkwk"); // > 20 character

        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        Assertions.assertEquals(2, violations.size()); // check total validasi apakah ada 2

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println("====== Validation =========");
            System.out.println("Message : " + violation.getMessage()); //mendapatkan message errornya apa
            System.out.println("Bean : " + violation.getLeafBean()); //mendapatkan object fieldnya itu ada dimana
            System.out.println("Constraint : " + violation.getConstraintDescriptor().getAnnotation()); //anotation apa yang menjadiakan ini eror
            System.out.println("Path : " + violation.getPropertyPath()); // field apa sih erornya
            System.out.println("Invalid Value : " + violation.getInvalidValue());// value apa sih yang dianggap tidak valid
            System.out.println("===========================\n");
        }
    }

    @Test
    void testValidationSuccess() {

        Person person = new Person();
        person.setFirstName("Hanif");
        person.setLastName("Amrullah");

        Set<ConstraintViolation<Person>> validate = validator.validate(person);
        Assertions.assertEquals(0, validate.size());
    }
}
