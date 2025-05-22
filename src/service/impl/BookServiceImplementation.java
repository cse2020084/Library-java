package service.impl;

import model.Book;
import repository.BookRepository;
import service.interfaces.BookServiceInterface;

public class BookServiceImplementation implements BookServiceInterface{
    private final BookRepository bookRepository;

    public BookServiceImplementation(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void addNewBookById(Book book) {
        if(this.bookRepository.getBookById(book.getBookId())!=null){
            System.out.println("Book already available");
            return;
        }

        this.bookRepository.addNewBook(book);
    }

    @Override
    public Book getBookById(String bookId) {
        if(this.bookRepository.getBookById(bookId)==null){
            System.out.println("Book not available");
            return null;
        }

        return this.bookRepository.getBookById(bookId);
    }
    
}
