package com.sda.bookstore.project.service;


import com.sda.bookstore.project.model.*;

public interface OrderService {
    Order createOrder(ShoppingCart shoppingCart,
                      ShippingAddress shippingAddress,
                      BillingAddress billingAddress,
                      Payment payment,
                      String shippingMehod,
                      User user);

    Order findOne(Long id);
}
