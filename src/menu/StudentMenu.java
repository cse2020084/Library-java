package menu;

public class StudentMenu implements LibraryMenuInterface{
    public void printMainMenu() {
        System.out.println("\n--- Student Menu ---");
        System.out.println("1. Add Book");
        System.out.println("2. Get Book by ID");
        System.out.println("3. List All Book");
        System.out.println("4. Back");
    }    
}
