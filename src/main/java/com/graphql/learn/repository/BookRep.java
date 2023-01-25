package com.graphql.learn.repository;

import com.graphql.learn.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRep extends MongoRepository<Book, Integer> {
    Book findById(String id);
}
