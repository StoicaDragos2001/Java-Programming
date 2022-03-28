package commands;

import catalog.Catalog;
import exception.CustomException;
import instances.Item;
import java.io.*;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;

public class InfoCommand extends GenericCommand{
    public InfoCommand(Catalog catalog) {
        super(catalog);
        callMethod = "info method";
    }

    @Override
    public void execute(String stringGiven) throws CustomException, IOException, ClassNotFoundException {
        catalog.getItems().forEach(item -> {
            System.out.println( item.getTitle() );
            showMetadata(item);
        });
    }
    private void showMetadata(Item item) {
        ContentHandler handler = new BodyContentHandler();
        AutoDetectParser parser = new AutoDetectParser();
        Metadata metadata = new Metadata();
        ParseContext parseContext = new ParseContext();

        try (InputStream stream = new FileInputStream(String.valueOf(item))) {
            parser.parse(stream, handler, metadata, parseContext);
            System.out.println("Document Metadata:");

            String[] metadataArray = metadata.names();

            for(String data : metadataArray) {
                System.out.println(data + ": " + metadata.get(data));
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
