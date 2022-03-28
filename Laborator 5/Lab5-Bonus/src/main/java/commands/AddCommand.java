package commands;
import catalog.Catalog;
import exception.CustomException;
import instances.Article;
import instances.Book;

/**
 * class AddCommand that extends GenericCommand
 * @author Petrea Daniela
 */
public class AddCommand extends GenericCommand {
    public AddCommand(Catalog catalog) {
        super(catalog);
        callMethod = "add method";
    }
    /**
     * I overwrite execute method
     * @param stringGiven that I parse s.t. I cand add the Item in the catalog
     * @throws CustomException if the id of the item is already in the list of items
     */
    @Override
    public void execute(String stringGiven) throws CustomException {
        String[] arrOfStr = stringGiven.split(String.valueOf(','), 6);
        int year = Integer.parseInt(arrOfStr[3]);
        if (arrOfStr[5].equals("book"))
            catalog.add( new Book(arrOfStr[0], arrOfStr[1], arrOfStr[2], year, arrOfStr[4], arrOfStr[5]));
        if (arrOfStr[5].equals("article"))
            catalog.add(new Article(arrOfStr[0], arrOfStr[1], arrOfStr[2], year, arrOfStr[4], arrOfStr[5]));
    }

}
