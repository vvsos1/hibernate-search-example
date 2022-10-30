package com.example.hibernatesearchexample;

import com.example.hibernatesearchexample.book.application.port.in.AddAuthorUseCase;
import com.example.hibernatesearchexample.book.application.port.in.AddBookUseCase;
import com.example.hibernatesearchexample.book.domain.Author;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories(basePackages = {"com.example.hibernatesearchexample.book.adapter.out.persistence"})
@SpringBootApplication
public class HibernateSearchExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateSearchExampleApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(AddAuthorUseCase addAuthorUseCase, AddBookUseCase addBookUseCase) {
        return args -> {
            Author author = addAuthorUseCase.addAuthor(new AddAuthorUseCase.Command("감자"));
            addBookUseCase.addBook(new AddBookUseCase.Command(
                    "감자의 일상",
                    "978-89-356-0120-2-03810",
                    100,
                    List.of(author.getName())));

            Author author2 = addAuthorUseCase.addAuthor(new AddAuthorUseCase.Command("고구마"));
            Author author3 = addAuthorUseCase.addAuthor(new AddAuthorUseCase.Command("짱구"));
            addBookUseCase.addBook(new AddBookUseCase.Command(
                    "고구마의 하루",
                    "978-89-356-0120-2-03811",
                    200,
                    List.of(author2.getName(), author3.getName())));
        };
    }

}
