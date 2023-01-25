package com.graphql.learn.resolver;

import com.graphql.learn.model.Book;
import com.graphql.learn.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class QueryResolver {

    @Autowired
    private BookService bookService;

    @QueryMapping("allBooks")
    public List<Book> getAll() {
        return this.bookService.getAll();
    }

    //get single book
    @QueryMapping("getBook")
    public Book get(@Argument String bookId) {
        return this.bookService.get(bookId);
    }
}
