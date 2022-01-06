package com.hanifiamdev.validation.constraint;

import com.hanifiamdev.validation.group.CreditCardPaymentGroup;
import com.hanifiamdev.validation.group.VirtualAccountPaymentGroup;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Size;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Documented
@Constraint(
        validatedBy = {CheckPasswordValidator.class}
)
@Target( {FIELD, ANNOTATION_TYPE, TYPE})
@Retention(RUNTIME)
public @interface CheckPassword {

    String message() default "password and retype passwored must same";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
