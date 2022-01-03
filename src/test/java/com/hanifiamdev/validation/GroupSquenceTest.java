package com.hanifiamdev.validation;

import com.hanifiamdev.validation.group.PaymentGroup;
import org.junit.jupiter.api.Test;

public class GroupSquenceTest extends AbstractValidatorTest {

    @Test
    void tstGroupSequence() {
        Payment payment = new Payment();
        payment.setOrderId("0001");
        payment.setAmount(20_000L);
        payment.setCreditCard("41111111111111");

        validateWithGroup(payment, PaymentGroup.class);


    }
}
