package com.example.library.library.dataTransferObjects.request;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class BookId {

    @NotBlank(message = "Id is required")
    private final String bookId;

    public BookId(String bookId) {
        this.bookId = bookId;
    }
}
