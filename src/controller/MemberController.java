package controller;

import exceptions.BookNotAvailableException;
import input.InputProvider;
import menu.LibraryMenuInterface;
import model.Book;
import service.interfaces.BookServiceInterface;

public class MemberController implements LibraryControllerInterface {
    private LibraryMenuInterface libraryMenuInterface;
    private InputProvider inputProvider;
    private BookServiceInterface bookServiceInterface;
    private final int MEMBER_CODE;

    @Override
    public void run() {
        this.libraryMenuInterface.printMainMenu();
        boolean back=false;
        while(!back){
            int choice=this.inputProvider.inputForChoice();
            switch (choice) {
                case 1:
                    Book book=inputProvider.inputToAddNewBook();
                    this.bookServiceInterface.addNewBookById(book);
                    break;
                case 2:
                    String bookId=this.inputProvider.inputToGetBookById();
                    try{
                        Book getbook=this.bookServiceInterface.getBookById(bookId);
                        if(getbook!=null) System.out.println("The Book is granted to you as titled.. ' "+getbook.getBookTitle()+" ' by author - ' "+getbook.getAuthorName()+" '");
                    }catch(BookNotAvailableException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try{
                        String bookIdForDeletion=this.inputProvider.inputToGetBookById();
                        boolean deleteStatus=this.bookServiceInterface.deleteBook(bookIdForDeletion,MEMBER_CODE);
                        if(deleteStatus) System.out.println("Book with id "+bookIdForDeletion+" is deleted");
                    }catch(Exception e){
                        
                    }
                    break;
                default:
                    break;
            }
        }
    }

    public MemberController(LibraryMenuInterface libraryMenuInterface,InputProvider inputProvider,BookServiceInterface bookServiceInterface,int MEMBER_CODE){
        this.libraryMenuInterface=libraryMenuInterface;
        this.bookServiceInterface=bookServiceInterface;
        this.inputProvider=inputProvider;
        this.MEMBER_CODE=MEMBER_CODE;
    }


    
}
