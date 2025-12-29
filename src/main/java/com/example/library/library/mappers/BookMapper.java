package com.example.library.library.mappers;

import com.example.library.library.database.BookEntity;
import com.example.library.library.dataTransferObjects.request.BookRequest;
import com.example.library.library.dataTransferObjects.response.BookResponse;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {



    public BookResponse toResponse(BookEntity entity) {
        if (entity == null) return null;

        return new BookResponse(
                entity.getId(),
                entity.getAuthor(),
                entity.getBookName(),
                entity.getDescription(),
                entity.getCost()
        );
    }



    public BookEntity toEntity(BookRequest request) {
        if (request == null) return null;

        return new BookEntity(
                request.getName(),
                request.getAuthor(),
                request.getDescription(),
                request.getCost()
        );
    }



    public void updateEntity(BookRequest request, BookEntity entity) {
        if (request == null || entity == null) return;

        entity.setBookName(request.getName());
        entity.setAuthor(request.getAuthor());
        entity.setDescription(request.getDescription());
        entity.setCost(request.getCost());
    }
}