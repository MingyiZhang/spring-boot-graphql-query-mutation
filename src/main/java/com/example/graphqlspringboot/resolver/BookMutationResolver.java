package com.example.graphqlspringboot.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphqlspringboot.model.Book;
import com.example.graphqlspringboot.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BookMutationResolver implements GraphQLMutationResolver {

  private BookService bookService;

  @Autowired
  public BookMutationResolver(BookService bookService) {
    this.bookService = bookService;
  }

  public Book insertBook(Book book) {
    bookService.insertBook(book);
    return new Book(book.getTitle(), book.getIsbn());
  }

  public Book deleteBook(String isbn) {
    Book bookToDelete = bookService.getBookByIsbn(isbn).orElse(null);
    bookService.deleteBook(isbn);
    return bookToDelete;
  }

  public Book updateBook(String isbn, String title) {
    Book bookToUpdate = new Book(title, isbn);
    int status = bookService.updateBook(isbn, bookToUpdate);
    log.debug("Update book status: " + status);
    return bookToUpdate;
  }
}
