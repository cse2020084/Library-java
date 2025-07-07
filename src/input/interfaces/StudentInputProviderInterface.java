package input.interfaces;

import model.Book;

public interface StudentInputProviderInterface {
    Book inputToAddNewBook();
    String inputToGetBookById();
    int inputForChoice();
}
