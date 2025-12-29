package com.example.library.library.database;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "books")
public class BookEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bookName", nullable = false)
    private String bookName;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "cost", nullable = false)
    private Double cost;

    public BookEntity(String username, String email, String description, Double cost) {
        this.bookName = username;
        this.author = email;
        this.description = description;
        this.cost = cost;
    }


}
