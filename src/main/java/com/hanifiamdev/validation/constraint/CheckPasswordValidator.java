package com.hanifiamdev.validation.constraint;

import com.hanifiamdev.validation.Register;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CheckPasswordValidator implements ConstraintValidator<CheckPassword, Register> {

    @Override
    public boolean isValid(Register value, ConstraintValidatorContext context) {
        if(value.getPassword() == null || value.getRetypePassword() == null) {
            return true; // skip validation
        }
        return value.getPassword().equals(value.getRetypePassword());
    }
}
