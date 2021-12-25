package com.hanifiamdev.validation;

import com.hanifiamdev.validation.group.CreditCardPaymentGroup;
import com.hanifiamdev.validation.group.VirtualAccountPaymentGroup;
import org.junit.jupiter.api.Test;

public class GroupTest extends AbstractValidatorTest{

    @Test
    void testCreditCardGroup() {

        Payment payment = new Payment();
        payment.setOrderId("0111");
        payment.setAmount(20_000L);
        payment.setCreditCard("123");

        validateWithGroup(payment, CreditCardPaymentGroup.class);
    }

    @Test
    void testVirtualAccount() {

        Payment payment = new Payment();
        payment.setOrderId("0111");
        payment.setAmount(20_000L);
        payment.setVirtualAccount("");

        validateWithGroup(payment, VirtualAccountPaymentGroup.class);
    }
}
