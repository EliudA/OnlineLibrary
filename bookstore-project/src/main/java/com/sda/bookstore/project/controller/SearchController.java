package com.sda.bookstore.project.controller;


import com.sda.bookstore.project.model.Book;
import com.sda.bookstore.project.model.User;
import com.sda.bookstore.project.service.BookService;
import com.sda.bookstore.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
//@RequestMapping(value="/search")
public class SearchController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    //@RequestMapping("/searchByCategory")
    @GetMapping("/searchByCategory")
    public String searchByCategory(
            @RequestParam("category") String category,
            Model model, Principal principal
    ) {
        if(principal != null) {
            String username = principal.getName();
            User user = userService.findByUsername(username);
            model.addAttribute("user", user);
        }

        String classActiveCategory = "active"+category;
        classActiveCategory = classActiveCategory.replaceAll("\\s","");
        classActiveCategory = classActiveCategory.replaceAll("&","");
        model.addAttribute("classActiveCategory", true);

        List<Book> bookList = bookService.findByCategory(category);

        if(bookList.isEmpty()) {
            model.addAttribute("emptyList", true);
            return "bookshelf";
        }

        model.addAttribute("bookList", bookList);

        return "bookshelf";
    }

    //@RequestMapping("/searchBook")
    @PostMapping("/searchBook")
    public String searchBook(
            @ModelAttribute("keyword") String keyword,
            Principal principal, Model model) {

        if(principal != null) {
            String username = principal.getName();
            User user = userService.findByUsername(username);
            model.addAttribute("user", user);
        }

        List<Book> bookList = bookService.blurrySearch(keyword);

        if(bookList.isEmpty()) {
            model.addAttribute("emptyList", true);
            return "bookshelf";
        }

        model.addAttribute("bookList", bookList);



        return "bookshelf";
    }
}
