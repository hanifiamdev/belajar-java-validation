package com.hanifiamdev.validation;

import com.hanifiamdev.validation.group.CreditCardPaymentGroup;
import org.junit.jupiter.api.Test;

public class CustomConstraintTest extends AbstractValidatorTest{

    @Test
    void testCustomConstraint() {

        Payment payment = new Payment();
        payment.setOrderId("hanif");

        validateWithGroup(payment, CreditCardPaymentGroup.class);

    }
}
