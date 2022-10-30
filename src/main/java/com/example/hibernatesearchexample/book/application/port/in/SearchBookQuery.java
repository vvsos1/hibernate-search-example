package com.example.hibernatesearchexample.book.application.port.in;

import com.example.hibernatesearchexample.book.domain.Book;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.hibernate.validator.constraints.Length;
import shared.SelfValidating;

import javax.validation.constraints.NotBlank;
import java.util.List;

public interface SearchBookQuery {
    List<Book> searchBook(Query query);

    @EqualsAndHashCode(callSuper = false)
    @Value
    class Query extends SelfValidating<Query> {
        @NotBlank
        @Length(min = 2)
        String query;

        public Query(String query) {
            this.query = query;
            this.validateSelf();
        }
    }
}
