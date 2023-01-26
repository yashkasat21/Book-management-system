package com.graphql.learn;

import com.graphql.learn.model.Book;
import com.graphql.learn.model.BookInput;
import com.graphql.learn.services.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class GraphqlProjectApplicationTests {

	@Autowired
	private BookService bookService;

	@Test
	void contextLoads() {
	}

	@Test
	@Order(1)
	public void createBookTest() {
		Book b = new Book();
		b.setId("000111aaa");
		b.setAuthor("Charlie");
		b.setDesc("Good Book");
		b.setPages(500);
		b.setPrice(5000);
		b.setTitle("Stoicism");
		Book r = bookService.create(b);
		Assertions.assertNotNull(r);
	}

	@Test
	@Order(2)
	public void getAllBooksTest() {
		List<Book> r = bookService.getAll();
		Assertions.assertNotNull(r);
	}

	@Test
	@Order(3)
	public void deleteBookTest() {
		String r = bookService.delete("000111aaa");
		Assertions.assertEquals("Book deleted Successfully", r);
	}

}
