package config;

import controller.LibraryController;
import input.*;
import menu.LibraryMenu;
import repository.BookRepository;
import service.interfaces.BookServiceInterface;
import service.impl.*;

public class LibraryConfig {
    public LibraryController getLibraryController(){
        InputReader inputReader=new ConsoleInputReader();
        InputProvider inputProvider=new InputProvider(inputReader);

        BookRepository bookRepository=new BookRepository();
        BookServiceInterface bookServiceInterface=new BookServiceImplementation(bookRepository);

        LibraryMenu libraryMenu=new LibraryMenu();

        return new LibraryController(libraryMenu,bookServiceInterface,inputProvider);
    }

        
    
}
