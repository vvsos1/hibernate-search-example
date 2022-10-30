package com.example.hibernatesearchexample.book.adapter.out.persistence;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Indexed
class BookJpaEntity {

    @GeneratedValue
    @Id
    private Long id;

    @FullTextField(analyzer = "korean")
    private String title;

    @KeywordField
    private String isbn;

    @GenericField
    private Integer pageCount;

    @IndexedEmbedded
    @JoinTable(name = "author_book")
    @ManyToMany
    private Set<AuthorJpaEntity> authors;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookJpaEntity that = (BookJpaEntity) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
