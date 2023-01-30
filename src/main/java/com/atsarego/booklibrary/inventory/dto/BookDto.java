package com.atsarego.booklibrary.inventory.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder(toBuilder = true)
public class BookDto {
    private final Integer id;

    @NonNull
    private final String name;
}
