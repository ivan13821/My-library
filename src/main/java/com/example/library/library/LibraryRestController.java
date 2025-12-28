package com.example.library.library;
import com.example.library.library.libraryLogic.BookLogic;
import com.example.library.library.models.Book;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/library")
class LibraryRestController {

    BookLogic bookLogic = new BookLogic();

    @GetMapping
    public ResponseEntity<String> getAllBooks() {
        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok()
                .headers(headers)
                .body(bookLogic.getAllBooks());
    }



    @PostMapping("/add")
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok()
                .headers(headers)
                .body(bookLogic.addBook(book));

    }



    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteBook(@RequestBody Map<String, String> request) {
        String name = request.get("name");

        if (name == null || name.isBlank()) {
            return ResponseEntity.badRequest()
                    .body("Field 'name' is required in JSON body");
        }

        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok()
                .headers(headers)
                .body(bookLogic.deleteBook(name));
    }

}