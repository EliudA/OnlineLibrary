package com.sda.bookstore.project.service;

import com.sda.bookstore.project.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    Book findOne(Long book_id);

    List<Book> findByCategory(String category);

    List<Book> blurrySearch(String title);
    
    Book save(Book book);

    void removeOne(Long book_id);
}
