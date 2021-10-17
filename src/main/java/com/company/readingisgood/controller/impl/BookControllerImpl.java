package com.company.readingisgood.controller.impl;

import com.company.readingisgood.controller.BookController;
import com.company.readingisgood.dto.input.BookCreateDto;
import com.company.readingisgood.dto.output.BookOutputDto;
import com.company.readingisgood.dto.input.BookUpdateDto;
import com.company.readingisgood.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class BookControllerImpl implements BookController {

    private final BookService bookService;

    /**
     * Handles the incoming POST request
     *
     * @param request fields of Book to be added
     * @return BookOutputDto
     */
    @Override
    public ResponseEntity<BookOutputDto> createBook(@Valid @RequestBody BookCreateDto request){
        return new ResponseEntity<>(bookService.create(request), HttpStatus.OK);
    }

    /**
     * Handles the incoming PUT request "/{id}"
     *
     * @param id of the Book to be updated
     * @param request fields of BookUpdateDto to update stock
     * @return Boolean
     */
    @Override
    public ResponseEntity<Boolean> updateBook(@PathVariable(value = "id") Long id, @Valid @RequestBody BookUpdateDto request){
        return new ResponseEntity<>(bookService.update(id, request), HttpStatus.OK);
    }
}
