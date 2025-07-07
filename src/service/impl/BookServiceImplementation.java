package service.impl;

import java.util.Map;

import exceptions.BookNotAvailableException;
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
    public Book getBookById(String bookId) throws BookNotAvailableException{
        if(this.bookRepository.getBookById(bookId)==null){
            // System.out.println("Book not available");
            throw new BookNotAvailableException("Book not available");
        }

        return this.bookRepository.getBookById(bookId);
    }

    @Override
    public Map<String,Book> listAllBook() {
        if(this.bookRepository.getAllBook()!=null){
            return this.bookRepository.getAllBook();
        }
        return null;
    }

    public boolean deleteBook(String bookIdForDeletion,int MEMBER_CODE){
        try{
            if(MEMBER_CODE!=2) return false;
            Map<String,Book> listAllBook=this.bookRepository.getOriginalBookRepoMap(MEMBER_CODE);
            if(listAllBook!=null){
                for(var book:listAllBook.entrySet()){
                    if(book.getKey().equals(bookIdForDeletion)){
                        Book lastBook=listAllBook.remove(bookIdForDeletion);
                        return lastBook==null ? false:true;
                    }
                }
            }
        }catch(Exception e){

        }
        
        return false;
    }
    
}
