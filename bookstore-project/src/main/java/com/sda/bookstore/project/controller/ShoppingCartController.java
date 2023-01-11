package com.sda.bookstore.project.controller;


import com.sda.bookstore.project.model.Book;
import com.sda.bookstore.project.model.CartItem;
import com.sda.bookstore.project.model.ShoppingCart;
import com.sda.bookstore.project.model.User;
import com.sda.bookstore.project.service.BookService;
import com.sda.bookstore.project.service.CartItemService;
import com.sda.bookstore.project.service.UserService;
import com.sda.bookstore.project.service.impl.ShoppingCartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
//@RequestMapping("/shoppingCart")
public class ShoppingCartController {

    @Autowired
    private UserService userService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private BookService bookService;

    @Autowired
    private ShoppingCartServiceImpl shoppingCartService;

    // @RequestMapping("/cart")
    @GetMapping("/cart")
    public String shoppingCart(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        ShoppingCart shoppingCart = user.getShoppingCart();

        List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);

        shoppingCartService.updateShoppingCart(shoppingCart);

        model.addAttribute("cartItemList", cartItemList);
        model.addAttribute("shoppingCart", shoppingCart);

        return "shoppingCart";
    }

    //@RequestMapping("/addItem")
    @PostMapping("/addItem")
    public String addItem(
            @ModelAttribute("book") Book book,
            @ModelAttribute("qty") String qty,
            Model model, Principal principal
    ) {
        User user = userService.findByUsername(principal.getName());
        book = bookService.findOne(book.getBook_id());

        if (Integer.parseInt(qty) > book.getInStockNumber()) {
            model.addAttribute("notEnoughStock", true);
            //return "forward:/home/bookDetail?id="+book.getBook_id();
           // return "forward:/bookDetail?id=" + book.getBook_id();
            return "forward:/cart";
        }

        CartItem cartItem = cartItemService.addBookToCartItem(book, user, Integer.parseInt(qty));
        model.addAttribute("addBookSuccess", true);

        //return "forward:/home/bookDetail?id="+book.getBook_id();
        return "forward:/bookDetail?id=" + book.getBook_id();
    }

    // @RequestMapping("/updateCartItem")
    @GetMapping("/updateCartItem")
    public String updateshoppingCart(
            @ModelAttribute("id") Long cartItemId,
            @ModelAttribute("qty") int qty
    ) {
        CartItem cartItem = cartItemService.findById(cartItemId);
        cartItem.setQty(qty);
        cartItemService.updateCartItem(cartItem);

        // return "forward:/shoppingCart/cart";
        return "forward:/cart";
    }

    //@RequestMapping("/removeItem")
    @GetMapping("/removeItem")
    public String removeItem(@RequestParam("id") Long cartItemId) {
        cartItemService.removeCartItem(cartItemService.findById(cartItemId));

        //return "forward:/shoppingCart/cart";
        return "forward:/cart";
    }
}
