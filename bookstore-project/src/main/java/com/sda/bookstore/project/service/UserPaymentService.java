package com.sda.bookstore.project.service;


import com.sda.bookstore.project.model.UserPayment;

public interface UserPaymentService {
    UserPayment findById(Long id);

    void removeById(Long id);
}
