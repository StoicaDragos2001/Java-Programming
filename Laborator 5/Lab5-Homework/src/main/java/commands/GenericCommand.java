package commands;

import catalog.Catalog;
import exception.CustomException;
import instances.Item;

import java.io.IOException;

public abstract class GenericCommand {
    String callMethod;
    Catalog catalog;

    public GenericCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public String getCallMethod() {
        return callMethod;
    }

    public abstract void execute(String stringGiven) throws CustomException, IOException, ClassNotFoundException;
}
