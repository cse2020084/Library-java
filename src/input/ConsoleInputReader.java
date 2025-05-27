package input;

import java.util.Scanner;

public class ConsoleInputReader implements InputReader {
    private final Scanner scanner=new Scanner(System.in);
    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        return Integer.parseInt(scanner.nextLine());
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        String res= scanner.nextLine().trim();
        return res;
    }




    
}
