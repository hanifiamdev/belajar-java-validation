package com.hanifiamdev.validation;

import com.hanifiamdev.validation.group.CreditCardPaymentGroup;
import com.hanifiamdev.validation.payload.EmailErrorPayload;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Payload;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class PayloadTest extends AbstractValidatorTest{

    @Test
    void testpayload() {

        Payment payment = new Payment();
        payment.setOrderId("0001");
        payment.setAmount(20_000L);
        payment.setCreditCard("31111"); // invalid

        Set<ConstraintViolation<Object>> violations = validator.validate(payment, CreditCardPaymentGroup.class);
        for (ConstraintViolation<Object> violation : violations) {
            System.out.println("Message : " + violation.getMessage()); //mendapatkan message errornya apa
            System.out.println("Path : " + violation.getPropertyPath()); // field apa sih erornya

            Set<Class<? extends Payload>> payload = violation.getConstraintDescriptor().getPayload();
            for (Class<? extends Payload> aClass : payload) {
                EmailErrorPayload emailErrorPayload = new EmailErrorPayload();
                emailErrorPayload.sendEmail(violation);
            }
            System.out.println("===========================\n");
        }

    }
}
