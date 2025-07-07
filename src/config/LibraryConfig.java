package config;

import controller.LibraryController;
import controller.LibraryControllerInterface;
import controller.MemberController;
import controller.StudentController;
import input.*;
import menu.LibraryMenu;
import menu.LibraryMenuInterface;
import menu.MainMenu;
import menu.MemberMenu;
import menu.StudentMenu;
import repository.BookRepository;
import service.interfaces.BookServiceInterface;
import service.impl.*;

/*
 * Role of config --
 * It acts as a manual dependency injector — creating and connecting objects.
 * In real projects, this is usually handled by frameworks like Spring.
 * Your LibraryConfig is playing the role of a configuration class.
 */

public class LibraryConfig {
    private final int MEMBER_CODE=2;
    
    // public LibraryController getLibraryController(){
    //     InputReader inputReader=new ConsoleInputReader();
    //     InputProvider inputProvider=new InputProvider(inputReader);

    //     BookRepository bookRepository=new BookRepository();
    //     BookServiceInterface bookServiceInterface=new BookServiceImplementation(bookRepository);

    //     LibraryMenu libraryMenu=new LibraryMenu();

    //     return new LibraryController(libraryMenu,bookServiceInterface,inputProvider);
    // }

    public LibraryControllerInterface getLibraryController(){
        InputReader inputReader=new ConsoleInputReader();
        InputProvider inputProvider=new InputProvider(inputReader);
        BookRepository bookRepository=new BookRepository();
        BookServiceInterface bookServiceInterface=new BookServiceImplementation(bookRepository);

        LibraryMenuInterface mainMenu=new MainMenu();
        LibraryControllerInterface memberController=new MemberController(new MemberMenu(),new MemberInputProvider(inputReader),bookServiceInterface,MEMBER_CODE);
        LibraryControllerInterface studentController=new StudentController(new StudentMenu(),new StudentInputProvider(inputReader),bookServiceInterface);



        return new LibraryController(mainMenu,  inputProvider,memberController,studentController);
    }

    

        
    
}
