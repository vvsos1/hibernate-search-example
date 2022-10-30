package com.example.hibernatesearchexample.book.application.port.out;

import com.example.hibernatesearchexample.book.domain.Book;

public interface SaveBookPort {

    Book saveBook(Book book);
}
