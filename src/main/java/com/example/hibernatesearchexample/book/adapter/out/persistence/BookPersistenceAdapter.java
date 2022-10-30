package com.example.hibernatesearchexample.book.adapter.out.persistence;

import com.example.hibernatesearchexample.book.application.port.out.SaveBookPort;
import com.example.hibernatesearchexample.book.domain.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
class BookPersistenceAdapter implements SaveBookPort {
    private final BookJpaEntityRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public Book saveBook(Book book) {
        BookJpaEntity entity = bookMapper.toEntity(book);
        entity = bookRepository.save(entity);
        return bookMapper.toDomain(entity);
    }
}
