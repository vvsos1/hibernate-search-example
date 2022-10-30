package com.example.hibernatesearchexample.book.application.port.out;

import com.example.hibernatesearchexample.book.domain.Author;

public interface LoadAuthorPort {

    Author loadAuthorByName(String name);
}
