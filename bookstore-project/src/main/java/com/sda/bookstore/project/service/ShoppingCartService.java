package com.sda.bookstore.project.service;

import com.sda.bookstore.project.model.ShoppingCart;

public interface ShoppingCartService {
    
	ShoppingCart updateShoppingCart(ShoppingCart shoppingCart);

    void clearShoppingCart(ShoppingCart shoppingCart);
}
