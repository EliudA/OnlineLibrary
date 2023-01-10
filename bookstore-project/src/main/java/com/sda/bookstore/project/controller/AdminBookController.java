package com.sda.bookstore.project.controller;


import com.sda.bookstore.project.model.Book;
import com.sda.bookstore.project.service.BookService;
//import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


@Controller
//@RequestMapping(value="/book")
public class AdminBookController {


    @Autowired
    private BookService bookService;

    //@RequestMapping(value = "/add", method = RequestMethod.GET)
    @GetMapping("/add")
    public String addBook(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "addBook";
    }

   // @RequestMapping(value = "/add", method = RequestMethod.POST)
    @PostMapping("/add")
    public String addBookPost(@ModelAttribute("book") Book book ){
                              //HttpServletRequest request) {
        bookService.save(book);
        // bookImage = book.getBookImage();
        MultipartFile bookImage = book.getBookImage();

        try {
            byte[] bytes = bookImage.getBytes();
            String name = book.getBook_id() + ".jpg";
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/static/image/book/" + name)));
            stream.write(bytes);
            stream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }



        return "redirect:bookList";
    }

  // @RequestMapping("/bookInfo")
    @GetMapping("/bookInfo")
    public String bookInfo(@RequestParam("id") Long id, Model model) {
        //Book book = bookService.findOne(id);
        Book book = bookService.findOne(id);
        model.addAttribute("book", book);
        return "bookInfo";
    }

   // @RequestMapping("/updateBook")
    @GetMapping("/updateBook")
    public String updateBook(@RequestParam("id") Long id, Model model) {
        Book book = bookService.findOne(id);
        model.addAttribute("book", book);

        return "updateBook";
    }

   // @RequestMapping(value="/updateBook", method=RequestMethod.POST)
    @PostMapping("/updateBook")
    public String updateBookPost(@ModelAttribute("book") Book book, HttpServletRequest request) {
        bookService.save(book);

        MultipartFile bookImage = book.getBookImage();

        if(!bookImage.isEmpty()) {
            try {
                byte[] bytes = bookImage.getBytes();
                String name = book.getBook_id() + ".jpg";

                Files.delete(Paths.get("src/main/resources/static/image/book/"+name));

                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(new File("src/main/resources/static/image/book/" + name)));
                stream.write(bytes);
                stream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

       // return "redirect:/book/bookInfo?id="+book.getBook_id();
        return "redirect:/bookInfo?id="+book.getBook_id();
    }

   // @RequestMapping("/bookList")
    @GetMapping("/bookList")
    public String bookList(Model model) {
        List<Book> bookList = bookService.findAll();
        model.addAttribute("bookList", bookList);
        return "bookList";
    }

    //@RequestMapping(value="/remove", method=RequestMethod.POST)
    @PostMapping("/remove")
    public String remove(@ModelAttribute("id") String id, Model model) {
        bookService.removeOne(Long.parseLong(id.substring(8)));
        List<Book> bookList = bookService.findAll();
        model.addAttribute("bookList", bookList);

        //return "redirect:/book/bookList";
        return "redirect:/bookList";
    }
    
    
    
    @GetMapping("delete/{id}")
    public String deleteBook(@PathVariable("id") long id, Model model) {
        //Book book = bookService.findOne(id);
        		bookService.removeOne(id);
        model.addAttribute("bookList", bookService.findAll());
        //return "redirect:/book/bookList";
        return "redirect:/bookList";
    }
    
    
    
   // @RequestMapping(value="/removeList", method=RequestMethod.POST)
    @PostMapping("/removeList")
    public String removeList(
            @RequestBody ArrayList<String> bookIdList, Model model
    ) {
        for(String id : bookIdList) {
            String bookId = id.substring(8);
            bookService.removeOne(Long.parseLong(bookId));
        }

        return "delete success";
    }
	
}
