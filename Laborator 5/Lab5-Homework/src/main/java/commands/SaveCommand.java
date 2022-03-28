package commands;

import catalog.Catalog;
import com.fasterxml.jackson.databind.ObjectMapper;
import exception.CustomException;
import instances.Item;

import java.io.File;
import java.io.IOException;
/**
 * class SaveCommand that extends GenericCommand
 * @author Petrea Daniela
 */
public class SaveCommand extends GenericCommand{
    public SaveCommand(Catalog catalog) {
        super(catalog);
        callMethod = "save method";
    }

    @Override
    public void execute(String stringGiven) throws IOException {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(
                    new File(stringGiven),
                    catalog);
        }
    }
