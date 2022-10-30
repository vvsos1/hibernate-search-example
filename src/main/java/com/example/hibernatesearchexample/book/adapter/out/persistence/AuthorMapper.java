package com.example.hibernatesearchexample.book.adapter.out.persistence;

import com.example.hibernatesearchexample.book.domain.Author;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING
        , unmappedSourcePolicy = ReportingPolicy.WARN
        , unmappedTargetPolicy = ReportingPolicy.WARN)
interface AuthorMapper {

    @Mapping(source = "id", target = "id.value")
    Author toDomain(AuthorJpaEntity entity);

    @InheritInverseConfiguration
    AuthorJpaEntity toEntity(Author domain);
}
