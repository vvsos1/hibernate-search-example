package com.example.hibernatesearchexample.book.adapter.out.persistence;

import com.example.hibernatesearchexample.book.application.port.out.LoadAuthorPort;
import com.example.hibernatesearchexample.book.application.port.out.SaveAuthorPort;
import com.example.hibernatesearchexample.book.domain.Author;
import com.example.hibernatesearchexample.book.domain.AuthorNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
class AuthorPersistenceAdapter implements LoadAuthorPort, SaveAuthorPort {
    private final AuthorJpaEntityRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Override
    public Author loadAuthorByName(String name) {
        AuthorJpaEntity entity = authorRepository.findByName(name)
                .orElseThrow(AuthorNotFound::new);
        return authorMapper.toDomain(entity);
    }

    @Override
    public Author saveAuthor(Author author) {
        AuthorJpaEntity entity = authorMapper.toEntity(author);
        entity = authorRepository.save(entity);
        return authorMapper.toDomain(entity);
    }


}
