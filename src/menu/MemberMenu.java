package menu;

public class MemberMenu implements LibraryMenuInterface{
    public void printMainMenu() {
        System.out.println("\n--- Member Menu ---");
        System.out.println("1. Add Book");
        System.out.println("2. Get Book by ID");
        System.out.println("3. Delete Book");
        System.out.println("4. Back");
    }
}
