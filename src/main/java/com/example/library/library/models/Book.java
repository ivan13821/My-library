package com.example.library.library.models;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Book {
    private String author;
    private String name;
    private String description;
    private double cost;

    public Book(String author, String name, String description, double cost) {
        this.author = author;
        this.cost = cost;
        this.name = name;
        this.description = description;
    }
}
