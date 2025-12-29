package com.example.library.library.dataTransferObjects.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BookResponse {

    private Long id;
    private String author;
    private String name;
    private String description;
    private Double cost;
}