package com.example.library.library.database;
import com.example.library.library.dataTransferObjects.Book;
import com.example.library.library.dataTransferObjects.UpdateBook;

import java.util.ArrayList;


public class LibraryDatabase {
    private final ArrayList<Book> books = new ArrayList<Book>();
    private long bookId = 0;

    private long createBookId () {
        bookId += 1;
        return bookId;
    }


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



    public Book getBookById(long bookId) {
        for (Book i : books) {
            if (i.getBookId() == bookId)
                return i;
        }
        return null;
    }



    public String addBook(Book book) {
        try {
            book.setBookId(createBookId());
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


    public String updateBook(UpdateBook updateBook) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookId() == updateBook.getBookId()) {

                Book book = books.get(i);

                if (updateBook.getAuthor() != null)
                    book.setAuthor(updateBook.getAuthor());
                if (updateBook.getName() != null)
                    book.setName(updateBook.getName());
                if (updateBook.getDescription() != null)
                    book.setDescription(updateBook.getDescription());
                if (updateBook.getCost() != null)
                    book.setCost(updateBook.getCost());

                books.set(i, book);

                return "Success";
            }
        }
        return "Произошла ошибка при добавлении книги";
    }

}
