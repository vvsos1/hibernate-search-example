package com.example.hibernatesearchexample.book.application.port.in;

import com.example.hibernatesearchexample.book.domain.Author;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;
import shared.SelfValidating;

public interface AddAuthorUseCase {

    Author addAuthor(Command command);

    @Getter
    class Command extends SelfValidating<Command> {
        @Length(min = 2)
        private final String name;

        public Command(String name) {
            this.name = name;
            this.validateSelf();
        }
    }
}
