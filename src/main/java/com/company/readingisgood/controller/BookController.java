package com.company.readingisgood.controller;

import com.company.readingisgood.dto.input.BookCreateDto;
import com.company.readingisgood.dto.output.BookOutputDto;
import com.company.readingisgood.dto.input.BookUpdateDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RequestMapping("/v1/book")
public interface BookController {

    @PostMapping()
    ResponseEntity<BookOutputDto> createBook(@Valid @RequestBody BookCreateDto request);

    @PutMapping("/{id}")
    ResponseEntity<Boolean> updateBook(@PathVariable(value = "id") Long id, @Valid @RequestBody BookUpdateDto request);

}
