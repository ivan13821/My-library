package com.example.library.library.dataTransferObjects.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UpdateBook {

    @NotBlank(message = "Id is required")
    private final long bookId;
    private final String author;
    private final String name;
    private final String description;
    private final Double cost;

    public UpdateBook(long bookId, String author, String name, String description, Double cost) {
        this.author = author;
        this.cost = cost;
        this.name = name;
        this.description = description;
        this.bookId = bookId;
    }
}
