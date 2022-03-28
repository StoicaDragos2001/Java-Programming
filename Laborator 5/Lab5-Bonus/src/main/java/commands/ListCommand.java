package commands;
import catalog.Catalog;
import exception.CustomException;

import java.io.IOException;
/**
 * class ListCommand that extends GenericCommand
 * @author Petrea Daniela
 */
public class ListCommand extends GenericCommand{
    public ListCommand(Catalog catalog) {
        super(catalog);
        callMethod = "list method";
    }

    @Override
    public void execute(String stringGiven) throws CustomException, IOException, ClassNotFoundException {
        System.out.println(catalog.getItems());
    }


}
