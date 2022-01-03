package com.hanifiamdev.validation;

import org.junit.jupiter.api.Test;

public class GroupConvertTest extends AbstractValidatorTest {

    @Test
    void testGroupConvert() {

        Payment payment = new Payment();
        payment.setOrderId("001");
        payment.setAmount(20_000L);
        payment.setCreditCard("411111111111");
        payment.setCustomer(new Customer());
    }
}
