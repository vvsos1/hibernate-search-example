package com.example.hibernatesearchexample.book.application.service;

import com.example.hibernatesearchexample.book.application.port.in.AddAuthorUseCase;
import com.example.hibernatesearchexample.book.application.port.out.SaveAuthorPort;
import com.example.hibernatesearchexample.book.domain.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
class AddAuthorService implements AddAuthorUseCase {
    private final SaveAuthorPort saveAuthorPort;

    @Override
    public Author addAuthor(Command command) {
        Author author = Author.create(command.getName());
        return saveAuthorPort.saveAuthor(author);
    }
}
