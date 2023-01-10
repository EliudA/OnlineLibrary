package com.sda.bookstore.project.service.impl;


import com.sda.bookstore.project.model.UserPayment;
import com.sda.bookstore.project.repository.UserPaymentRepository;
import com.sda.bookstore.project.service.UserPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPaymentServiceImpl implements UserPaymentService {

    @Autowired
    private UserPaymentRepository userPaymentRepository;

    public UserPayment findById(Long id) {
        return userPaymentRepository.findById(id).get();
    }

    public void removeById(Long id) {
        userPaymentRepository.deleteById(id);
    }
}
