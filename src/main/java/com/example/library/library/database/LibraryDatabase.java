package com.example.library.library.database;
import com.example.library.library.models.Book;

import java.util.ArrayList;
import java.util.Objects;




public class LibraryDatabase {
    private final ArrayList<Book> books = new ArrayList<Book>();

    public ArrayList<Book> getAllBooks() {
        return books;
    }



    public Book getBookByName(String name) {
        for (Book i : books) {
            if (i.getName().equals(name))
                return i;
        }
        return null;
    }



    public String addBook(Book book) {
        try {
            books.add(book);
            return "Success";
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
            return "Произошла ошибка при добавлении книги";
        }
    }



    public void deleteBook(String name) {
        books.removeIf(book -> book.getName().equals(name));
    }

}
