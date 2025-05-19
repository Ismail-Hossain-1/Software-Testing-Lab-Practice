package org.example.BookLender;

public interface BookRepo {
    Book findBookById(String Id);
    Book save(Book book);
}
