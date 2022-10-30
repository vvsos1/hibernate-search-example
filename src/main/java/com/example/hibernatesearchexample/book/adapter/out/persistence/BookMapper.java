package com.example.hibernatesearchexample.book.adapter.out.persistence;

import com.example.hibernatesearchexample.book.domain.Book;
import org.mapstruct.*;

@Mapper(uses = {AuthorMapper.class}
        , componentModel = MappingConstants.ComponentModel.SPRING
        , unmappedSourcePolicy = ReportingPolicy.WARN
        , unmappedTargetPolicy = ReportingPolicy.WARN)
interface BookMapper {

    @Mapping(source = "id", target = "id.value")
    Book toDomain(BookJpaEntity entity);

    @InheritInverseConfiguration
    BookJpaEntity toEntity(Book domain);
}
