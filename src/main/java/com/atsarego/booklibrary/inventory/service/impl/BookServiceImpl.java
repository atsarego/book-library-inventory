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
    public BookDto getBook(@Nonnull Integer id) {
        return null;
    }

    @Nonnull
    @Override
    public Integer addBook(@Nonnull BookDto book) {
        return null;
    }
}
