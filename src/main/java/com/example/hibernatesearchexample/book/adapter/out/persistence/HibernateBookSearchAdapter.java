package com.example.hibernatesearchexample.book.adapter.out.persistence;

import com.example.hibernatesearchexample.book.application.port.out.SearchBookPort;
import com.example.hibernatesearchexample.book.domain.Book;
import lombok.RequiredArgsConstructor;
import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RequiredArgsConstructor
@Component
public class HibernateBookSearchAdapter implements SearchBookPort {

    @PersistenceContext
    private final EntityManager em;
    private final BookMapper bookMapper;

    @Override
    public List<Book> search(String query) {
        SearchSession session = Search.session(em);
        SearchResult<BookJpaEntity> books = session.search(BookJpaEntity.class)
                .where(f -> f.match()
                        .fields("title", "authors.name")
                        .matching(query))
                .fetch(20);
        return books.hits().stream().map(bookMapper::toDomain).toList();
    }
}
