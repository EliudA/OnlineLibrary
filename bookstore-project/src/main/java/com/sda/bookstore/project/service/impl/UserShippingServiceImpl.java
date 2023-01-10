package com.sda.bookstore.project.service.impl;


import com.sda.bookstore.project.model.UserShipping;
import com.sda.bookstore.project.repository.UserShippingRepository;
import com.sda.bookstore.project.service.UserShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserShippingServiceImpl implements UserShippingService {

    @Autowired
    private UserShippingRepository userShippingRepository;

    public UserShipping findById(Long id) {
        return userShippingRepository.findById(id).get();
    }

    public void removeById(Long id) {
        userShippingRepository.deleteById(id);
    }
}
