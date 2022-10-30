package com.example.hibernatesearchexample.book.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface AuthorJpaEntityRepository extends JpaRepository<AuthorJpaEntity, Long> {
    Optional<AuthorJpaEntity> findByName(String name);
}
