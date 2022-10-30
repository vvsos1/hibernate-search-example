package com.example.hibernatesearchexample.book.application.service;

import com.example.hibernatesearchexample.book.application.port.in.AddBookUseCase;
import com.example.hibernatesearchexample.book.application.port.out.LoadAuthorPort;
import com.example.hibernatesearchexample.book.application.port.out.SaveBookPort;
import com.example.hibernatesearchexample.book.domain.Author;
import com.example.hibernatesearchexample.book.domain.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
class AddBookService implements AddBookUseCase {
    private final SaveBookPort saveBookPort;
    private final LoadAuthorPort loadAuthorPort;

    @Override
    public Book addBook(Command command) {
        Set<Author> authors = command.getAuthorNames().stream()
                .map(loadAuthorPort::loadAuthorByName).collect(Collectors.toSet());

        Book book = Book.create(
                command.getTitle(),
                command.getIsbn(),
                command.getPageCount(),
                authors);

        return saveBookPort.saveBook(book);
    }

}
