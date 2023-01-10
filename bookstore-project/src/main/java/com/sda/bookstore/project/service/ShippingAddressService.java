package com.sda.bookstore.project.service;


import com.sda.bookstore.project.model.ShippingAddress;
import com.sda.bookstore.project.model.UserShipping;

public interface ShippingAddressService {
    ShippingAddress setByUserShipping(UserShipping userShipping, ShippingAddress shippingAddress);
}
