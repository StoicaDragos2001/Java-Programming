import catalog.Catalog;
import com.github.javafaker.Faker;
import commands.*;
import exception.CustomException;
import instances.Article;
import instances.Book;
import randomizer.RandomInstances;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * class Main
 * @author Petrea Daniela
 */
public class Main {
    public static void main(String args[]) throws IOException, CustomException, ClassNotFoundException {
        Main app = new Main();
        app.homework();
    }

    private void homework() throws CustomException, IOException, ClassNotFoundException {
        try {
            Scanner input = new Scanner(System.in);
            Catalog catalog = new Catalog("MyRefs");
            Faker faker = new Faker();
            RandomInstances randomizer = new RandomInstances();
            int numberOfItems = randomizer.generateNumberOfItems();
            for (int index = 0; index < numberOfItems; index++)
                if (randomizer.whichItem() == 0) {
                    List<String> details = new ArrayList<>();
                    String id = faker.name().username();
                    details.add("book");
                    Book item = new Book(id, faker.book().title(), faker.internet().url(), randomizer.randomYear(), faker.book().author(), "book");
                    if (randomizer.whichItem() == 0) {
                        details.add("with photos");
                        if (randomizer.whichItem() == 0)
                            details.add("encyclopedia");
                        else
                            details.add("comics");
                    } else {
                        details.add("without photos");
                        if (randomizer.whichItem() == 0) {
                            details.add("fiction");
                            if (randomizer.whichItem1() == 0)
                                details.add("children's fiction");
                            else if (randomizer.whichItem1() == 1)
                                details.add("young adult fiction");
                            else if (randomizer.whichItem1() == 2)
                                details.add("new adult fiction");
                            else
                                details.add("adult fiction");
                        } else {
                            details.add("non-fiction");
                            if (randomizer.whichItem2() == 0)
                                details.add("history");
                            else if (randomizer.whichItem2() == 1) {
                                details.add("memoirs");
                                if (randomizer.whichItem() == 0)
                                    details.add("biographies");
                                else
                                    details.add("autobiographies");
                            } else if (randomizer.whichItem2() == 2)
                                details.add("travel guides");
                            else if (randomizer.whichItem2() == 3)
                                details.add("academic texts");
                            else if (randomizer.whichItem2() == 2)
                                details.add("journalism");
                        }
                    }
                    catalog.setDetails(details);
                    catalog.add(item);
                } else {
                    List<String> details = new ArrayList<>();
                    String id = faker.name().username();
                    details.add("article");
                    Article item = (new Article(id, faker.book().title(), faker.internet().url(), randomizer.randomYear(), faker.artist().name(), "article"));
                    if (randomizer.whichItem() == 0) {
                        details.add("printed");
                        if (randomizer.whichItem() == 0)
                            details.add("archived");
                        else {
                            details.add("most read");
                            if (randomizer.whichItem() == 0)
                                details.add("weekly");
                            else
                                details.add("monthly");
                        }
                    } else {
                        details.add("web");
                        if (randomizer.whichItem() == 0) {
                            details.add("newspaper");
                            if (randomizer.whichItem3() == 0)
                                details.add("news report");
                            else if (randomizer.whichItem3() == 1) {
                                details.add("feature articles");
                            } else {
                                details.add("editorials");
                            }
                        } else {
                            details.add("magazine");
                            if (randomizer.whichItem1() == 0)
                                details.add("art");
                            else if (randomizer.whichItem1() == 1)
                                details.add("cooking");
                            else if (randomizer.whichItem1() == 2)
                                details.add("fashion");
                            else
                                details.add("tech");
                        }
                    }
                    catalog.setDetails(details);
                    catalog.add(item);
                }
            System.out.println(catalog.getTags());
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
                    case "load" -> {
                        LoadCommand loadCommand = new LoadCommand(catalog);
                        loadCommand.execute("C:\\Users\\Daniela-211021\\IdeaProjects\\research\\catalog.json");
                    }
                    case "info" -> {
                        InfoCommand infoCommand = new InfoCommand(catalog);
                        infoCommand.execute("");
                    }
                    case "save" -> {
                        SaveCommand saveCommand = new SaveCommand(catalog);
                        saveCommand.execute("C:\\Users\\Daniela-211021\\IdeaProjects\\research\\catalog.json");
                    }
                    case "toString" -> {
                        ToStringCommand toStringCommand = new ToStringCommand(catalog);
                        toStringCommand.execute("");
                    }
                    case "report" -> {
                        ReportCommand reportCommand = new ReportCommand(catalog);
                        reportCommand.execute("./");
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
