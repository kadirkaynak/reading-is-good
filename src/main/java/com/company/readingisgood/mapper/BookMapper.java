package com.company.readingisgood.mapper;

import com.company.readingisgood.dto.input.BookCreateDto;
import com.company.readingisgood.dto.output.BookOutputDto;
import com.company.readingisgood.entity.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

    Book toBook(BookCreateDto bookCreateDto);
    BookOutputDto toBookOutputDto(Book book);

}
