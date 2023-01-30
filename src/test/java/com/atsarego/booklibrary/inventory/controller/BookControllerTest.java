package com.atsarego.booklibrary.inventory.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.atsarego.booklibrary.inventory.dto.BookDto;
import com.atsarego.booklibrary.inventory.service.BookService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

@WebMvcTest(BookController.class)
public class BookControllerTest {
    private static final BookDto BOOK_1 = BookDto.builder()
            .id(1)
            .name("name-1")
            .build();

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private BookService bookService;

    @Test
    public void getAllBooksTest() throws Exception {
        when(bookService.getAllBooks()).thenReturn(List.of(BOOK_1));

        final String response = mockMvc.perform(get("/books"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        assertThat(
                objectMapper.readValue(response, new TypeReference<Iterable<BookDto>>() {
                }),
                containsInAnyOrder(is(BOOK_1))
        );
    }

    @Test
    public void getBookTest() throws Exception {
        when(bookService.getBook(BOOK_1.getId())).thenReturn(BOOK_1);

        final String response = mockMvc.perform(get("/books/{id}", BOOK_1.getId()))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        assertThat(
                objectMapper.readValue(response, BookDto.class),
                is(BOOK_1)
        );
    }

    @Test
    public void getNotExistedBookTest() throws Exception {
        mockMvc.perform(get("/books/{id}", 0))
                .andExpect(status().isNotFound());
    }

    @Test
    public void addBookTest() throws Exception {
        final BookDto book = BookDto.builder()
                .name("book-1")
                .build();
        final int bookId = 1;
        when(bookService.addBook(book)).thenReturn(bookId);
        mockMvc.perform(post("/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(book)))
                .andExpectAll(
                        status().isCreated(),
                        content().string(Integer.toString(bookId))
                );
    }
}
