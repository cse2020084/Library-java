import config.LibraryConfig;

public class App {
    /*
     * del /s *.class
     * To delete class file
     * just make sure to remain outof src and in the library-primary
     * using cd ..
     */
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Library Management System!");
        LibraryConfig libraryConfig=new LibraryConfig();
        libraryConfig.getLibraryController().run();
    }
}
