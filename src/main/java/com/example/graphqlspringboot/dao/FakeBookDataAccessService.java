package com.example.graphqlspringboot.dao;

import com.example.graphqlspringboot.model.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository("fakeDao")
public class FakeBookDataAccessService implements BookDao {

  private static List<Book> DB = new ArrayList<>();

  @Override
  public int insertBook(Book book) {
    DB.add(new Book(book.getTitle(), book.getIsbn()));
    return 1;
  }

  @Override
  public List<Book> selectAllBooks() {
    return DB;
  }

  @Override
  public Optional<Book> selectBookByIsbn(String isbn) {
    return DB.stream()
        .filter(book -> book.getIsbn().equals(isbn))
        .findFirst();
  }

  @Override
  public int deleteBookByIsbn(String isbn) {
    Optional<Book> book = selectBookByIsbn(isbn);
    if (book.isEmpty()) {
      return 0;
    }
    DB.remove(book.get());
    return 1;
  }

  @Override
  public int updateBookByIsbn(String isbn, Book bookToUpdate) {
    return selectBookByIsbn(isbn)
        .map(book -> {
          int indexOfBookToUpdate = DB.indexOf(book);
          if (indexOfBookToUpdate > 0) {
            DB.set(indexOfBookToUpdate, new Book(bookToUpdate.getTitle(), isbn));
            return 1;
          }
          return 0;
        })
        .orElse(0);
  }
}
