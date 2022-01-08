package com.hanifiamdev.validation;

import com.hanifiamdev.validation.extractor.DataIntegerValueExtractor;
import com.hanifiamdev.validation.extractor.DataValueExtractor;
import com.hanifiamdev.validation.extractor.EntryValueExtractorKey;
import com.hanifiamdev.validation.extractor.EntryValueExtractorValue;
import jakarta.validation.*;
import jakarta.validation.executable.ExecutableValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.Set;

public abstract class AbstractValidatorTest {

    protected ValidatorFactory validatorFactory;

    protected Validator validator;

    protected ExecutableValidator executableValidator;

    protected MessageInterpolator messageInterpolator;

    @BeforeEach
    void setUp() {
       //  validatorFactory = Validation.buildDefaultValidatorFactory();
        validatorFactory = Validation.byDefaultProvider().configure()
                .addValueExtractor(new DataValueExtractor())
                .addValueExtractor(new EntryValueExtractorKey())
                .addValueExtractor(new EntryValueExtractorValue())
                .addValueExtractor(new DataIntegerValueExtractor())
                .buildValidatorFactory();

        validator = validatorFactory.getValidator();
        executableValidator = validator.forExecutables();
        messageInterpolator = validatorFactory.getMessageInterpolator();
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

    void validateWithException(Object o) {
        Set<ConstraintViolation<Object>> violations = validator.validate(o);
       if(!violations.isEmpty()) {
           throw new ConstraintViolationException(violations);
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
