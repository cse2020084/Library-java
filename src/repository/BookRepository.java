package repository;
import java.util.*;
import model.Book;


public class BookRepository {
   private  Map<String,Book> bookRepoByBookId=new HashMap<>();

   public void addNewBook(Book book){
        bookRepoByBookId.put(book.getBookId(),book);
   }

   public Book getBookById(String bookId){
        return bookRepoByBookId.get(bookId);
   }

   public void removeBookById(String bookId){
        bookRepoByBookId.remove(bookId);
   }


}
