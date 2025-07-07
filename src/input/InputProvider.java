package input;

import model.Book;

public class InputProvider {
    private final InputReader inputReader;

    public InputProvider(InputReader inputReader){
        this.inputReader=inputReader;
    }

    public Book inputToAddNewBook(){
        String bookId=inputReader.readString("Add Book Id.. ");
        String bookTitle=inputReader.readString("Add Book Title.. ");
        String bookAuthor=inputReader.readString("Add Book AuthorName.. ");
        return new Book(bookId, bookTitle, bookAuthor, false);
    }
    
    public String inputToGetBookById(){
        String bookId=inputReader.readString("Enter Book Id.. ");
        return bookId;
    }

    public int inputForChoice(){
        return inputReader.readInt("Enter your Choice.. ");
    }
    
}
