package com.atsarego.booklibrary.inventory.service;

import com.atsarego.booklibrary.inventory.dto.BookDto;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

public interface BookService {
    @Nonnull
    Iterable<BookDto> getAllBooks();

    @Nullable
    BookDto getBook(@Nonnull Integer id);

    @Nonnull
    Integer addBook(@Nonnull BookDto book);
}
