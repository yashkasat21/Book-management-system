package com.graphql.learn;

import com.graphql.learn.model.Book;
import com.graphql.learn.model.BookInput;
import com.graphql.learn.repository.BookRep;
import com.graphql.learn.services.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
class GraphqlProjectApplicationTests {

	@Autowired
	private BookService bookService;

	@MockBean
	private BookRep bookRep;

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
		when(bookRep.save(b)).thenReturn(b);
		Book r = bookService.create(b);
		Assertions.assertNotNull(r);
	}

	@Test
	@Order(2)
	public void getAllBooksTest() {
		Book b = new Book();
		b.setId("000111aaa");
		b.setAuthor("Charlie");
		b.setDesc("Good Book");
		b.setPages(500);
		b.setPrice(5000);
		b.setTitle("Stoicism");
		List<Book> expected = new ArrayList<>();
		expected.add(b);
		when(bookRep.findAll()).thenReturn(expected);
		List<Book> r = bookService.getAll();
		Assertions.assertNotNull(r);
	}

	@Test
	@Order(3)
	public void deleteBookTest() {
		Book b = new Book();
		b.setId("000111aaa");
		b.setAuthor("Charlie");
		b.setDesc("Good Book");
		b.setPages(500);
		b.setPrice(5000);
		b.setTitle("Stoicism");
		when(bookRep.findById(b.getId())).thenReturn(b);
		doNothing().when(bookRep).delete(b);
		String r = bookService.delete("000111aaa");
		Assertions.assertEquals("Book deleted Successfully", r);
	}

}
