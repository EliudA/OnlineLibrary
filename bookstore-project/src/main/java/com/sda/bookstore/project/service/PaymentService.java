package com.sda.bookstore.project.service;

import com.sda.bookstore.project.model.Payment;
import com.sda.bookstore.project.model.UserPayment;

public interface PaymentService {
    Payment setByUserPayment(UserPayment userPayment, Payment payment);
}
