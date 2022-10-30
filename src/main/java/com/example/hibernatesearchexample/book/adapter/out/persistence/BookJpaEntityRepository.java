package com.example.hibernatesearchexample.book.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookJpaEntityRepository extends JpaRepository<BookJpaEntity, Long> {
}
