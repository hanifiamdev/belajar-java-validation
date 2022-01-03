package com.hanifiamdev.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.executable.ExecutableValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.Set;

public abstract class AbstractValidatorTest {

    protected ValidatorFactory validatorFactory;

    protected Validator validator;

    protected ExecutableValidator executableValidator;

    @BeforeEach
    void setUp() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
        executableValidator = validator.forExecutables();
    }

    @AfterEach
    void tearDown() {
        validatorFactory.close();
    }

    void validate(Object o) {
        Set<ConstraintViolation<Object>> violations = validator.validate(o);
        for (ConstraintViolation<Object> violation : violations) {
            System.out.println("====== Validation =========");
            System.out.println("Message : " + violation.getMessage()); //mendapatkan message errornya apa
            System.out.println("Path : " + violation.getPropertyPath()); // field apa sih erornya
            System.out.println("Invalid Value : " + violation.getInvalidValue());// value apa sih yang dianggap tidak valid
            System.out.println("Bean : " + violation.getLeafBean()); //mendapatkan object fieldnya itu ada dimana
            System.out.println("Constraint : " + violation.getConstraintDescriptor().getAnnotation()); //anotation apa yang menjadiakan ini eror
            System.out.println("===========================\n");
        }
    }

    void validateWithGroup(Object o, Class<?>... groups) {
        Set<ConstraintViolation<Object>> violations = validator.validate(o, groups);
        for (ConstraintViolation<Object> violation : violations) {
            System.out.println("====== Validation =========");
            System.out.println("Message : " + violation.getMessage()); //mendapatkan message errornya apa
            System.out.println("Path : " + violation.getPropertyPath()); // field apa sih erornya
            System.out.println("Invalid Value : " + violation.getInvalidValue());// value apa sih yang dianggap tidak valid
            System.out.println("Bean : " + violation.getLeafBean()); //mendapatkan object fieldnya itu ada dimana
            System.out.println("Constraint : " + violation.getConstraintDescriptor().getAnnotation()); //anotation apa yang menjadiakan ini eror
            System.out.println("===========================\n");
        }
    }
}
