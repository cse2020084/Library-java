package input;

import java.util.Scanner;

import exceptions.EmptyInputException;
import exceptions.LongInputException;


public class ConsoleInputReader implements InputReader {
    private final Scanner scanner=new Scanner(System.in);
    @Override
    public int readInt(String prompt) {
        Integer i=null;
        try {
            System.out.println(prompt);
            i= Integer.parseInt(scanner.nextLine()); 
            return i;          
        } catch (NumberFormatException e) {
            System.out.println(e.getLocalizedMessage());
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        String res= scanner.nextLine().trim();
        try{
            if(res.equals("")) throw new EmptyInputException("No Empty Input Allowed ");
            if(res.length()>3) throw new LongInputException("Trim length of Input to 3 character");
        }catch(EmptyInputException e){
            System.out.println(e.getMessage());
            return readString(prompt);
        }catch(LongInputException e){
            System.out.println(e.getLocalizedMessage());
            return readString(prompt);
        }
        catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }

        return res;
    }




    
}
