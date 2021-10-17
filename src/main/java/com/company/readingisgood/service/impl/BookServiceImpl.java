package com.company.readingisgood.service.impl;

import com.company.readingisgood.dto.input.BookCreateDto;
import com.company.readingisgood.dto.input.BookUpdateDto;
import com.company.readingisgood.dto.output.BookOutputDto;
import com.company.readingisgood.entity.Book;
import com.company.readingisgood.exception.BookNotFoundException;
import com.company.readingisgood.mapper.BookMapper;
import com.company.readingisgood.repository.BookRepository;
import com.company.readingisgood.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final SequenceGeneratorService sequenceGenerator;

    @Override
    public Book saveBook(Book book) {
        log.info(String.format("Date=%s|Request=%s",new Date(), book.toString()));
        return bookRepository.save(book);
    }

    @Override
    public Book findBookById(Long bookId) {
        return bookRepository.findById(bookId).orElseThrow(
                () -> new BookNotFoundException("Book could not find by id: " + bookId));
    }

    @Override
    public BookOutputDto create(BookCreateDto request){
        Book book = bookMapper.toBook(request);
        book.setBookId(sequenceGenerator.generateSequence(Book.SEQUENCE_NAME));
        return bookMapper.toBookOutputDto(saveBook(book));
    }

    @Override
    public boolean update(Long id, BookUpdateDto request){
        Book book = findBookById(id);
        book.setAmount(request.getAmount());
        saveBook(book);
        return true;
    }
}
