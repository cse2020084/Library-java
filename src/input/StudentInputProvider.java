package input;

import input.interfaces.StudentInputProviderInterface;
import model.Book;

public class StudentInputProvider extends InputProvider

{
    private final InputReader inputReader;

    public StudentInputProvider(InputReader inputReader){       
        super(inputReader);
        this.inputReader=inputReader;
    }





     
}
