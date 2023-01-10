package com.sda.bookstore.project.service.impl;

import com.sda.bookstore.project.model.Payment;
import com.sda.bookstore.project.model.UserPayment;
import com.sda.bookstore.project.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    public Payment setByUserPayment(UserPayment userPayment, Payment payment) {
        payment.setType(userPayment.getType());
        payment.setHolderName(userPayment.getHolderName());
        payment.setCardName(userPayment.getCardName());
        payment.setExpiryMonth(userPayment.getExpiryMonth());
        payment.setExpiryYear(userPayment.getExpiryYear());
        payment.setCvc(userPayment.getCvc());
        payment.setCardNumber(userPayment.getCardNumber());

        return payment;
    }
}
