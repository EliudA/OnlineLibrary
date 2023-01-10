package com.sda.bookstore.project.service.impl;


import com.sda.bookstore.project.model.BillingAddress;
import com.sda.bookstore.project.model.UserBilling;
import com.sda.bookstore.project.service.BillingAddressService;
import org.springframework.stereotype.Service;


@Service
public class BillingAddressServiceImpl implements BillingAddressService {

    public BillingAddress setByUserBilling(UserBilling userBilling, BillingAddress billingAddress) {
        billingAddress.setBillingAddressName(userBilling.getUserBillingName());
        billingAddress.setBillingAddressStreet1(userBilling.getUserBillingStreet1());
        billingAddress.setBillingAddressCity(userBilling.getUserBillingCity());
        billingAddress.setBillingAddressCounty(userBilling.getUserBillingCounty());
        billingAddress.setBillingAddressZipcode(userBilling.getUserBillingZipcode());

        return billingAddress;
    }
}
