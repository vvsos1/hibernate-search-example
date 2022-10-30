package com.example.hibernatesearchexample.book.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


@EqualsAndHashCode(of = "id")
@Getter
public class Book {

    private final Id id;

    private final String title;

    private final String isbn;

    private final Integer pageCount;
    private final Set<Author> authors;


    public Book(Id id, String title, String isbn, Integer pageCount, Set<Author> authors) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.pageCount = pageCount;
        this.authors = new HashSet<>(authors);
        this.authors.forEach(this::addAuthor);

    }

    public static Book create(String title, String isbn, Integer pageCount, Set<Author> authors) {
        return new Book(null, title, isbn, pageCount, authors);
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public Set<Author> getAuthors() {
        return Collections.unmodifiableSet(authors);
    }


    public record Id(Long value) {
    }
}
