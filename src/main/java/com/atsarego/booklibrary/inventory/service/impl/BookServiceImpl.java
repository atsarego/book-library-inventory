package com.atsarego.booklibrary.inventory.service.impl;

import com.atsarego.booklibrary.inventory.dto.BookDto;
import com.atsarego.booklibrary.inventory.service.BookService;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Nonnull
    @Override
    public Iterable<BookDto> getAllBooks() {
        return null;
    }

    @Nullable
    @Override
    public BookDto getBook(@Nonnull final Integer id) {
        return null;
    }

    @Nonnull
    @Override
    public Integer addBook(@Nonnull final BookDto book) {
        return null;
    }

    @Nonnull
    @Override
    public BookDto updateBook(@Nonnull final Integer id, @Nonnull final BookDto book) {
        return null;
    }

    @Override
    public void deleteBook(@Nonnull final Integer id) {

    }
}
