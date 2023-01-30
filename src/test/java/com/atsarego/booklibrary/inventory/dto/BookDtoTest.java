package com.atsarego.booklibrary.inventory.dto;

import static com.jayway.jsonpath.matchers.JsonPathMatchers.hasJsonPath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.aMapWithSize;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

@JsonTest
public class BookDtoTest {
    private static BookDto bookDto;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeAll
    public static void init() {
        bookDto = BookDto.builder()
                .id(1)
                .name("name-1")
                .build();
    }

    @Test
    public void serializeBookDtoTest() throws JsonProcessingException {
        assertThat(
                objectMapper.writeValueAsString(bookDto),
                allOf(
                        hasJsonPath("$", aMapWithSize(2)),
                        hasJsonPath("$.id", is(bookDto.getId())),
                        hasJsonPath("$.name", is(bookDto.getName())))
        );
    }

    @Test
    public void equalsBookDtoTest() {
        assertEquals(bookDto, bookDto.toBuilder().build());
    }
}
