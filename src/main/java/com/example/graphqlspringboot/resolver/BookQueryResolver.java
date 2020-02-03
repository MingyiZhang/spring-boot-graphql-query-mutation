package com.example.graphqlspringboot.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphqlspringboot.model.Book;
import com.example.graphqlspringboot.service.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookQueryResolver implements GraphQLQueryResolver {

  private BookService bookService;

  @Autowired
  public BookQueryResolver(BookService bookService) {
    this.bookService = bookService;
  }

  public List<Book> getAllBooks() {
    return bookService.getAllBooks();
  }

  public Book getBookByIsbn(String isbn) {
    return bookService.getBookByIsbn(isbn).orElse(null);
  }

}
