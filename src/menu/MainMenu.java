package menu;

public class MainMenu implements LibraryMenuInterface{
    public void printMainMenu(){
        System.out.println("\n---Menu ---");
        System.out.println("1. Student");
        System.out.println("2. Member");
        System.out.println("3. Exit");
    }
}
