package com.example.hibernatesearchexample.book.adapter.out.persistence;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.KeywordField;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
class AuthorJpaEntity {

    @GeneratedValue
    @Id
    private Long id;

    @KeywordField
    @Column(unique = true)
    private String name;

    // for hibernate-search
    @ManyToMany(mappedBy = "authors")
    private Set<BookJpaEntity> books;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthorJpaEntity that = (AuthorJpaEntity) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
