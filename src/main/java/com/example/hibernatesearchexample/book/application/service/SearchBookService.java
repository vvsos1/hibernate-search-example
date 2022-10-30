package com.example.hibernatesearchexample.book.application.service;

import com.example.hibernatesearchexample.book.application.port.in.SearchBookQuery;
import com.example.hibernatesearchexample.book.application.port.out.SearchBookPort;
import com.example.hibernatesearchexample.book.domain.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SearchBookService implements SearchBookQuery {
    private final SearchBookPort searchBookPort;

    @Override
    public List<Book> searchBook(Query query) {
        return searchBookPort.search(query.getQuery());
    }
}
