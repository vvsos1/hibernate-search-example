package com.example.hibernatesearchexample.book.adapter.in.web;

import com.example.hibernatesearchexample.book.application.port.in.AddBookUseCase;
import com.example.hibernatesearchexample.book.application.port.in.SearchBookQuery;
import com.example.hibernatesearchexample.book.domain.Book;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/books")
@RestController
class BookController {
    private final AddBookUseCase addBookUseCase;
    private final SearchBookQuery searchBookQuery;


    @PostMapping
    public Book addBook(@Valid AddBookRequest request) {
        AddBookUseCase.Command command = new AddBookUseCase.Command(request.getTitle(), request.getIsbn(), request.getPageCount(), request.getAuthorNames());

        return addBookUseCase.addBook(command);
    }

    @GetMapping
    public List<Book> searchBook(@Valid @NotBlank String query) {
        return searchBookQuery.searchBook(new SearchBookQuery.Query(query));
    }

    @Value
    static class AddBookRequest {
        @NotBlank
        String title;
        @NotNull
        @ISBN
        String isbn;
        @NotNull
        @Min(1)
        Integer pageCount;

        @Length(min = 1)
        List<@NotBlank String> authorNames;
    }


}
