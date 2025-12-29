package com.example.library.library.service;
import com.example.library.library.dataTransferObjects.response.BookResponse;
import com.example.library.library.database.BookEntity;
import com.example.library.library.database.BookRepository;
import com.example.library.library.dataTransferObjects.request.BookRequest;
import com.example.library.library.mappers.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;



    @Transactional
    public BookResponse createBook(BookRequest request) {
        if (bookRepository.existsByBookName(request.getName())) {
            throw new RuntimeException("Book with this name already exists");
        }

        BookEntity entity = bookMapper.toEntity(request);

        BookEntity savedEntity = bookRepository.save(entity);

        return bookMapper.toResponse(savedEntity);
    }



    public BookResponse getBookById(Long id) {
        BookEntity entity = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));

        return bookMapper.toResponse(entity);
    }



    public List<BookResponse> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toResponse)
                .collect(Collectors.toList());
    }



    @Transactional
    public BookResponse updateBook(Long id, BookRequest request) {
        BookEntity entity = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));

        bookMapper.updateEntity(request, entity);

        BookEntity updatedEntity = bookRepository.save(entity);

        return bookMapper.toResponse(updatedEntity);
    }



    @Transactional
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new RuntimeException("Book not found with id: " + id);
        }

        bookRepository.deleteById(id);
    }


}
