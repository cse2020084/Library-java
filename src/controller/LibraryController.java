package controller;

import input.InputProvider;
import menu.LibraryMenu;
import menu.LibraryMenuInterface;
import menu.MainMenu;
import model.Book;
import service.interfaces.BookServiceInterface;

/*
 *  Role of controller
 * Controls application flow, handles user inputs, and delegates to appropriate services or sub-controllers.
 * You are following an MVC-style structure — which is good and used everywhere (CLI, web, desktop, APIs).
 */

public class LibraryController implements LibraryControllerInterface {
    private final LibraryMenuInterface libraryMenu;
    private final LibraryControllerInterface memberController;
    private final LibraryControllerInterface studentController;
    private final InputProvider inputProvider;
    
    public LibraryController(LibraryMenuInterface libraryMenu,InputProvider inputProvider,LibraryControllerInterface memberController,LibraryControllerInterface studentController){
        this.libraryMenu=libraryMenu;
        this.inputProvider=inputProvider;
        this.memberController=memberController;
        this.studentController=studentController;
    }

    public void run(){
        this.libraryMenu.printMainMenu();
        boolean exit=false;
        while(!exit){
            int choice=this.inputProvider.inputForChoice();
            switch (choice) {
                case 1:
                    studentController.run();
                    this.libraryMenu.printMainMenu();
                    break;
                case 2:
                    memberController.run();
                    this.libraryMenu.printMainMenu();
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
