package commands;
import catalog.Catalog;
import exception.CustomException;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
/**
 * class ViewCommand that extends GenericCommand
 * @author Petrea Daniela
 */
public class ViewCommand extends GenericCommand{
    public ViewCommand(Catalog catalog) {
        super(catalog);
        callMethod = "view method";
    }

    @Override
    public void execute(String stringGiven) throws CustomException, IOException, ClassNotFoundException {
        String[] arrOfStr = stringGiven.split(String.valueOf(','), 6);
       if(arrOfStr[2].contains("www")) {
           URI u = null;
           try {
               u = new URI(arrOfStr[2]);
           } catch (URISyntaxException e) {
               e.printStackTrace();
           }
           Desktop d = Desktop.getDesktop();
           d.browse(u);
       }
       else
       {
           File u = new File(arrOfStr[2]);
           Desktop d = Desktop.getDesktop();
           d.open(u);
       }
    }
}
