import catalog.Catalog;
import commands.*;
import exception.CustomException;
import instances.Article;
import instances.Book;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws IOException, CustomException, ClassNotFoundException {
        Main app = new Main();
        app.homework();
    }

    private void homework() throws CustomException, IOException, ClassNotFoundException {
        try {
            Scanner input = new Scanner(System.in);
            Catalog catalog = new Catalog("MyRefs");
            Book item1 = new Book("pride13", "Pride and prejudice", "C:\\Users\\Daniela-211021\\IdeaProjects\\Lab5-Compulsory\\pride_and_prejudice.pdf", 1813, "Jane Austen", "book");
            Article item2 = new Article("java17", "The Java Language Specification", "https://docs.oracle.com/javase/specs/jls/se17/html/index.html", 2021, "James Gosling & others", "article");
            catalog.add(item1);
            catalog.add(item2);
            while (true) {
                System.out.print("The command is >>");
                String command = input.nextLine();
                String typeOfCommand = new Scanner(command).next();
                switch (typeOfCommand) {
                    case "add" -> {
                        AddCommand addCommand = new AddCommand(catalog);
                        addCommand.execute("knuth67,The Art of Computer Programming,d:/books/programming/tacp.ps,1967,Donald E. Knuth,book");
                        addCommand.execute("alice20,Alice in Wonderland,https://www.adobe.com/be_en/active-use/pdf/Alice_in_Wonderland.pdf,1951,Lewis Carroll,book");
                    }
                    case "list" -> {
                        ListCommand listCommand = new ListCommand(catalog);
                        listCommand.execute("");
                    }
                    case "save" -> {
                        SaveCommand saveCommand = new SaveCommand(catalog);
                        saveCommand.execute("C:\\Users\\Daniela-211021\\IdeaProjects\\research\\catalog2.json");
                    }
                    case "load" -> {
                        LoadCommand loadCommand = new LoadCommand(catalog);
                        loadCommand.execute("C:\\Users\\Daniela-211021\\IdeaProjects\\research\\catalog2.json");
                    }
                    case "toString" -> {
                        ToStringCommand toStringCommand = new ToStringCommand(catalog);
                        toStringCommand.execute("");
                    }
                    case "report" -> {
                        ReportCommand reportCommand = new ReportCommand(catalog);
                        reportCommand.execute("./");
                    }
                    case "info" -> {
                        InfoCommand infoCommand = new InfoCommand(catalog);
                        infoCommand.execute("");
                    }
                    case "view" -> {
                        ViewCommand viewCommand = new ViewCommand(catalog);
                        viewCommand.execute("alice20,Alice in Wonderland,https://www.adobe.com/be_en/active-use/pdf/Alice_in_Wonderland.pdf,1951,Lewis Carroll,book");
                    }
                    case "quit" -> {
                        return;
                    }
                    default -> throw new CustomException("Command not supported!");
                }
            }
        } catch (CustomException | IOException | ClassNotFoundException exp) {
            System.out.println(exp.getMessage());
        }
    }

}
