package commands;
import catalog.Catalog;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * class LoadCommand that extends GenericCommand
 * @author Petrea Daniela
 */
public class LoadCommand extends GenericCommand{
    public LoadCommand(Catalog catalog) {
        super(catalog);
        callMethod = "save method";
    }

    @Override
    public void execute(String stringGiven) throws IOException {
        Catalog catalog = new Catalog("myRefs");
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            catalog = objectMapper.readValue(new File(stringGiven), Catalog.class);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(catalog);
    }

}
