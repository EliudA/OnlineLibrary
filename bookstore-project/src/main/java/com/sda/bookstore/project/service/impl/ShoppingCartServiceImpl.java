package com.sda.bookstore.project.service.impl;

import com.sda.bookstore.project.model.CartItem;
import com.sda.bookstore.project.model.ShoppingCart;
import com.sda.bookstore.project.repository.ShoppingCartRepository;
import com.sda.bookstore.project.service.CartItemService;
import com.sda.bookstore.project.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    public ShoppingCart updateShoppingCart(ShoppingCart shoppingCart) {
        BigDecimal cartTotal = new BigDecimal(0);

        List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);

        for (CartItem cartItem : cartItemList) {
            if(cartItem.getBook().getInStockNumber() > 0) {
                cartItemService.updateCartItem(cartItem);
                cartTotal = cartTotal.add(cartItem.getSubtotal());
            }
        }

        shoppingCart.setGrandTotal(cartTotal);

        shoppingCartRepository.save(shoppingCart);

        return shoppingCart;
    }

    public void clearShoppingCart(ShoppingCart shoppingCart) {
        List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);

        for(CartItem cartItem : cartItemList) {
            cartItem.setShoppingCart(null);
            cartItemService.save(cartItem);

            shoppingCart.setGrandTotal(new BigDecimal(0));

            shoppingCartRepository.save(shoppingCart);
        }
    }
}
