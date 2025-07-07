package service.interfaces;

import java.util.Map;

import exceptions.BookNotAvailableException;
import model.Book;

public interface BookServiceInterface {
    void addNewBookById(Book book);
    Book getBookById(String bookId)  throws BookNotAvailableException;  
    Map<String,Book> listAllBook();
    boolean deleteBook(String bookIdForDeletion,int MEMBER_CODE);
}
