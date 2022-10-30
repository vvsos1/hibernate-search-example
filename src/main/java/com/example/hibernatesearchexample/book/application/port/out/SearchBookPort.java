package com.example.hibernatesearchexample.book.application.port.out;

import com.example.hibernatesearchexample.book.domain.Book;

import java.util.List;

public interface SearchBookPort {

    List<Book> search(String query);
}
