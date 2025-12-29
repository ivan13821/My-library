package com.example.library.library;
import com.example.library.library.dataTransferObjects.request.BookId;
import com.example.library.library.dataTransferObjects.request.UpdateBook;
import com.example.library.library.dataTransferObjects.response.BookResponse;
import com.example.library.library.service.BookService;
import com.example.library.library.dataTransferObjects.request.BookRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/library")
@RequiredArgsConstructor
class LibraryRestController {

    private final BookService bookService;



    @GetMapping
    public ResponseEntity<List<BookResponse>> getAllBooks() {
        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok()
                .headers(headers)
                .body(bookService.getAllBooks());
    }



    @PostMapping("/add")
    public ResponseEntity<BookResponse> addBook(@RequestBody BookRequest book) {
        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok()
                .headers(headers)
                .body(bookService.createBook(book));

    }



//    @DeleteMapping("/delete")
//    public ResponseEntity<String> deleteBook(@RequestBody BookId bookId) {
//        HttpHeaders headers = new HttpHeaders();
//        return ResponseEntity.ok()
//                .headers(headers)
//                .body(bookService.deleteBook(bookId.getBookId()));
//    }
//
//
//    @PostMapping("/update")
//    public ResponseEntity<String> updateBook(@RequestBody UpdateBook updateBook) {
//        HttpHeaders headers = new HttpHeaders();
//        return ResponseEntity.ok()
//                .headers(headers)
//                .body(bookService.updateBook(updateBook));
//    }

}