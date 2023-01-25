package com.graphql.learn.services.impl;

import com.graphql.learn.model.Book;
import com.graphql.learn.repository.BookRep;
import com.graphql.learn.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {


    private final BookRep bookRep;

    @Autowired
    public BookServiceImpl(BookRep bookRep) {
        this.bookRep = bookRep;
    }

    @Override
    public Book create(Book book) {
        return this.bookRep.save(book);
    }

    @Override
    public List<Book> getAll() {
        return this.bookRep.findAll();
    }

    @Override
    public Book get(String bookId) {
        Book b = this.bookRep.findById(bookId);
        if(b == null) {
            throw new RuntimeException("Book not found");
        }
        return b;
    }

    @Override
    public String delete(String bookId) {
        Book b;
        b = this.get(bookId);
        if(b == null) {
            throw new NullPointerException();
        }
        this.bookRep.delete(b);
        return "Book deleted Successfully";
    }
}
