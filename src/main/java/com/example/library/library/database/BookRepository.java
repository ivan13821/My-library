package com.example.library.library.database;
import io.micrometer.common.KeyValues;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
    boolean existsByBookName(@NotBlank(message = "Name is required") String name);

    KeyValues findByAuthor(String author);
}
