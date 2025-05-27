package controller;

import input.InputProvider;
import menu.LibraryMenu;
import model.Book;
import service.interfaces.BookServiceInterface;

public class LibraryController {
    private final LibraryMenu libraryMenu;
    private final BookServiceInterface bookServiceInterface;
    private final InputProvider inputProvider;
    
    public LibraryController(LibraryMenu libraryMenu,BookServiceInterface bookServiceInterface,InputProvider inputProvider){
        this.libraryMenu=libraryMenu;
        this.bookServiceInterface=bookServiceInterface;
        this.inputProvider=inputProvider;
    }

    public void run(){
        this.libraryMenu.printMainMenu();
        boolean exit=false;
        while(!exit){
            int choice=this.inputProvider.inputForChoice();
            switch (choice) {
                case 1:
                    Book book=this.inputProvider.inputToAddNewBook();
                    this.bookServiceInterface.addNewBookById(book);
                    break;
                case 2:
                    String bookId=this.inputProvider.inputToGetBookById();
                    Book getbook=this.bookServiceInterface.getBookById(bookId);
                    if(getbook!=null) System.out.println("The Book is granted to you as titled.. ' "+getbook.getBookTitle()+" ' by author - ' "+getbook.getAuthorName()+" '");
                    break;
                case 3:
                    System.out.println("Exiting...");
                    exit=true;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }

    }
}
