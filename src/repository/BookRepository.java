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

   public Map<String,Book> getAllBook(){
     if(bookRepoByBookId!=null){
          return new HashMap<>(bookRepoByBookId);
     }
     return null;
   }

   public Map<String,Book> getOriginalBookRepoMap(int MEMBER_CODE){
     if(MEMBER_CODE!=2) return null;
     if(bookRepoByBookId==null || bookRepoByBookId.size()==0) return null;
     return bookRepoByBookId;
   }


}
