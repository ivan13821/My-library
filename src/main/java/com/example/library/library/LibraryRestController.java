package com.example.library.library;
import com.example.library.library.dataTransferObjects.BookId;
import com.example.library.library.dataTransferObjects.UpdateBook;
import com.example.library.library.libraryLogic.BookLogic;
import com.example.library.library.dataTransferObjects.Book;
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
    public ResponseEntity<String> deleteBook(@RequestBody BookId bookId) {
        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok()
                .headers(headers)
                .body(bookLogic.deleteBook(bookId.getBookId()));
    }


    @PostMapping("/update")
    public ResponseEntity<String> updateBook(@RequestBody UpdateBook updateBook) {
        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok()
                .headers(headers)
                .body(bookLogic.updateBook(updateBook));
    }

}