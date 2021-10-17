package com.company.readingisgood.service;

import com.company.readingisgood.dto.input.BookCreateDto;
import com.company.readingisgood.dto.output.BookOutputDto;
import com.company.readingisgood.dto.input.BookUpdateDto;
import com.company.readingisgood.entity.Book;

public interface BookService {

    Book saveBook(Book book);
    Book findBookById(Long bookId);
    BookOutputDto create(BookCreateDto request);
    boolean update(Long id, BookUpdateDto request);

}
