package com.hanifiamdev.validation;

import com.hanifiamdev.validation.group.VirtualAccountPaymentGroup;
import org.junit.jupiter.api.Test;

public class MessageInterpolationTest extends AbstractValidatorTest{

    @Test
    void testMessage() {
        Payment payment = new Payment();
        payment.setOrderId("789057490594529095640");
        payment.setVirtualAccount("312313");
        payment.setAmount(10L);

        validateWithGroup(payment, VirtualAccountPaymentGroup.class);
    }
}
