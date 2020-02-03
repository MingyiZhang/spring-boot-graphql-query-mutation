package com.example.graphqlspringboot.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Book {

  @Getter
  @Setter
  private String title;
  @Getter
  @Setter
  private String isbn;

}
