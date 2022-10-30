package com.example.hibernatesearchexample.book.application.port.in;

import com.example.hibernatesearchexample.book.domain.Book;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.hibernate.validator.constraints.Length;
import shared.SelfValidating;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

public interface AddBookUseCase {

    Book addBook(Command command);

    @EqualsAndHashCode(callSuper = false)
    @Value
    class Command extends SelfValidating<Command> {
        @NotBlank
        @Length(min = 2, max = 100)
        String title;

        @NotBlank
        String isbn;

        @Min(1)
        Integer pageCount;
        List<String> authorNames;

        public Command(String title, String isbn, Integer pageCount, List<String> authorNames) {
            this.title = title;
            this.isbn = isbn;
            this.pageCount = pageCount;
            this.authorNames = authorNames;
            this.validateSelf();
        }
    }
}
