package com.example.hibernatesearchexample.book.adapter.in.web;

import com.example.hibernatesearchexample.book.application.port.in.AddAuthorUseCase;
import com.example.hibernatesearchexample.book.domain.Author;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RequiredArgsConstructor
@RequestMapping("/authors")
@RestController
class AddAuthorController {
    private final AddAuthorUseCase addAuthorUseCase;

    @PostMapping
    public Author registerAuthor(@Valid AddAuthorRequest request) {
        AddAuthorUseCase.Command command = new AddAuthorUseCase.Command(request.getName());
        return addAuthorUseCase.addAuthor(command);
    }

    @Value
    static class AddAuthorRequest {
        @NotBlank
        String name;
    }

}
