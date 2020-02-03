# Simple GraphQL Query and Mutation Example with Spring Boot

A simple implementation of GraphQL server with query and mutation using Spring Boot.

## Tech Stack
- Spring Boot
- GraphQL
- Gradle

## Description
A GraphQL server that can get, insert, delete and update data in a mocked database.

## Run
```shell script
gradle bootRun
```

## Query Examples
Run GraphiQL in `localhost:8080/graphiql`.

- __insertBook__
  ```graphql
  mutation insertBook($book: BookInput!) {
    insertBook(book: $book){
      title
      isbn
    }
  }
  ```
  example query variable
  ```json
  {
    "book": {
      "title": "Hi there!",
      "isbn": "12345"
    }
  }  
  ```
- getBookByIsbn
  ```graphql
  query getBookByIsbn($isbn: String!) {
    getBookByIsbn(isbn: $isbn){
      title
      isbn
    }
  }
  ```
  example query variable
  ```json
  {
    "isbn": "12345"
  }  
  ```
- getAllBooks
  ```graphql
  query getAllBooks {
    getAllBooks {
      title
      isbn
    }
  }
  ```
- updateBook
  ```graphql
  mutation updateBook($isbn: String!, $title: String!) {
    updateBook(isbn: $isbn, title: $title){
      title
      isbn
    }
  }
  ```
  example query variable
  ```json
  {
    "isbn": "12345",
    "title": "See you!"
  }  
  ```
- deleteBook
  ```graphql
  mutation deleteBook($isbn: String!){
    deleteBook(isbn: $isbn){
      title
      isbn
    }
  }
  ```
  example query variable
  ```json
  {
    "isbn": "12345"
  }
  ```