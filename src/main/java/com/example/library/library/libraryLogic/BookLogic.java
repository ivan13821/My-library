package com.example.library.library.libraryLogic;
import com.example.library.library.dataTransferObjects.UpdateBook;
import com.example.library.library.database.LibraryDatabase;
import com.example.library.library.dataTransferObjects.Book;

import java.util.ArrayList;

public class BookLogic {

    LibraryDatabase database = new LibraryDatabase();


    public String getAllBooks() {
        ArrayList<Book> books = database.getAllBooks();

        String answer = "";

        for (Book book : books) {
            answer = answer +
                    "Идентификатор: " + book.getBookId() + "\n" +
                    "Имя: " + book.getName() + "\n" +
                    "Автор: " + book.getAuthor() + "\n" +
                    "Описание: " + book.getDescription() + "\n" +
                    "Стоимость: " + book.getCost() + "\n" + "\n";
        }

        if (answer.isEmpty()) {
            return "В коллекции еще нет книг, добавьте первую)";
        }

        return answer;
    }



    public String addBook(Book book) {
        return database.addBook(book);
    }



    public String deleteBook(String name) {

        if (database.getBookByName(name) != null) {
            database.deleteBook(name);
            return "Успешно";
        }
        else {
            return "Такой книги не существует";
        }
    }


    public String updateBook(UpdateBook updateBook) {

        if (database.getBookById(updateBook.getBookId()) == null ) {
            return "Такой книги не существует";
        }

        return database.updateBook(updateBook);
    }


}
