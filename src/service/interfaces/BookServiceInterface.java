package service.interfaces;

import model.Book;

public interface BookServiceInterface {
    void addNewBookById(Book book);
    Book getBookById(String bookId);  
    
}
