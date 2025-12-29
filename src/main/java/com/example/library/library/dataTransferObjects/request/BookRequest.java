package com.example.library.library.dataTransferObjects.request;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BookRequest {

    private long bookId;

    @NotBlank(message = "Author is required")
    private String author;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Description is required")
    private String description;

    @NotBlank(message = "Cost is required")
    private Double cost;

    public BookRequest(String author, String name, String description, Double cost) {
        this.author = author;
        this.cost = cost;
        this.name = name;
        this.description = description;
    }
}
