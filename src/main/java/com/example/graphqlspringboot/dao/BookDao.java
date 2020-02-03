package com.example.graphqlspringboot.dao;

import com.example.graphqlspringboot.model.Book;
import java.util.List;
import java.util.Optional;

public interface BookDao {

  int insertBook(Book book);

  List<Book> selectAllBooks();

  Optional<Book> selectBookByIsbn(String isbn);

  int deleteBookByIsbn(String isbn);

  int updateBookByIsbn(String isbn, Book book);

}
