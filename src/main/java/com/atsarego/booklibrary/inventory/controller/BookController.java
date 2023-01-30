package com.atsarego.booklibrary.inventory.controller;

import com.atsarego.booklibrary.inventory.dto.BookDto;
import com.atsarego.booklibrary.inventory.exception.ResourceNotFoundException;
import com.atsarego.booklibrary.inventory.service.BookService;
import jakarta.annotation.Nonnull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(@Nonnull final BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    @Nonnull
    public Iterable<BookDto> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/books/{bookId}")
    @Nonnull
    public BookDto getBook(
            @PathVariable("bookId") @Nonnull final Integer id
    ) {
        return Optional.ofNullable(bookService.getBook(id))
                .orElseThrow(ResourceNotFoundException::new);
    }

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    @Nonnull
    public Integer addBook(@RequestBody @Nonnull BookDto book) {
        return bookService.addBook(book);
    }
}
