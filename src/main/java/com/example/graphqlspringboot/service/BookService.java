package com.example.graphqlspringboot.service;

import com.example.graphqlspringboot.dao.BookDao;
import com.example.graphqlspringboot.model.Book;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BookService {

  private final BookDao bookDao;

  @Autowired
  public BookService(@Qualifier("fakeDao") BookDao bookDao) {
    this.bookDao = bookDao;
  }

  public void insertBook(Book book) {
    bookDao.insertBook(book);
    log.debug("Add Book: " + book.getTitle());
  }

  public Optional<Book> getBookByIsbn(String isbn) {
    return bookDao.selectBookByIsbn(isbn);
  }

  public List<Book> getAllBooks() {
    return bookDao.selectAllBooks();
  }

  public int deleteBook(String isbn) {
    return bookDao.deleteBookByIsbn(isbn);
  }

  public int updateBook(String isbn, Book book) {
    return bookDao.updateBookByIsbn(isbn, book);
  }





}
