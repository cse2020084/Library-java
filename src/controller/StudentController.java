package controller;

import java.util.Iterator;
import java.util.Map;

import exceptions.BookNotAvailableException;
import input.ConsoleInputReader;
import input.InputProvider;
import input.InputReader;
import menu.LibraryMenuInterface;
import menu.StudentMenu;
import model.Book;
import service.interfaces.BookServiceInterface;

public class StudentController implements LibraryControllerInterface{
        //     while(!exit){
        //     int choice=this.inputProvider.inputForChoice();
        //     switch (choice) {
        //         case 1:
        //             Book book=this.inputProvider.inputToAddNewBook();
        //             this.bookServiceInterface.addNewBookById(book);
        //             break;
        //         case 2:
        //             String bookId=this.inputProvider.inputToGetBookById();
        //             Book getbook=this.bookServiceInterface.getBookById(bookId);
        //             if(getbook!=null) System.out.println("The Book is granted to you as titled.. ' "+getbook.getBookTitle()+" ' by author - ' "+getbook.getAuthorName()+" '");
        //             break;
        //         case 3:
        //             System.out.println("Exiting...");
        //             exit=true;
        //             break;
        //         default:
        //             System.out.println("Invalid choice");
        //             break;
        //     }
        // }
            private LibraryMenuInterface libraryMenuInterface;
            private InputProvider inputProvider;
            private BookServiceInterface bookServiceInterface;
            

            public StudentController(LibraryMenuInterface libraryMenuInterface, InputProvider inputProvider,BookServiceInterface bookServiceInterface) {
                this.libraryMenuInterface = libraryMenuInterface;
                this.inputProvider = inputProvider;
                this.bookServiceInterface = bookServiceInterface;
            }


            @Override
            public void run() {
                this.libraryMenuInterface.printMainMenu();
                
                boolean back=false;
                while(!back){
                    int choice=inputProvider.inputForChoice();
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
                            this.getBookListByMap(this.bookServiceInterface.listAllBook());
                            break;
                        case 4:
                            System.out.println("Returning to Main Menu...");
                            back=true;
                            break;                          
                        default:
                            System.out.println("Invalid choice");
                            break;
                    }
                }
            }


            private void getBookListByMap(Map<String,Book> bookRepo){
                if(bookRepo==null || bookRepo.isEmpty()){
                    System.out.println("Book Repository is Empty");
                    return;
                }
                Iterator<String> iterator=bookRepo.keySet().iterator();
                while(iterator.hasNext()){
                    String key=iterator.next();
                    System.out.println(bookRepo.get(key).getBookId()+" "+bookRepo.get(key).getBookTitle()+" "+bookRepo.get(key).getAuthorName());
                }
            }
            
}
