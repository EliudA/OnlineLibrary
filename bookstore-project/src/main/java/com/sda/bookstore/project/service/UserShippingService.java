package com.sda.bookstore.project.service;

import com.sda.bookstore.project.model.UserShipping;

public interface UserShippingService {
    UserShipping findById(Long id);

    void removeById(Long id);
}
