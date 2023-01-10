package com.sda.bookstore.project.service;


import com.sda.bookstore.project.model.BillingAddress;
import com.sda.bookstore.project.model.UserBilling;

public interface BillingAddressService {

    BillingAddress setByUserBilling(UserBilling userBilling, BillingAddress billingAddress);
}
