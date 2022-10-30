package com.example.hibernatesearchexample.book.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(of = "id")
@Getter
public class Author {

    private final Id id;

    private final String name;


    public Author(Id id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Author create(String name) {
        return new Author(null, name);
    }


    public record Id(Long value) {
    }
}
