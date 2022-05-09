import connection.EntityManagerFactory;
import repo.ContinentsRepo;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory.manager();
        ContinentsRepo repo = new ContinentsRepo();
        repo.printAll();
        System.out.println();
        repo.findById(5);
        //repo.create(1290,"newContinent");
        System.out.println();
        repo.findByName("Europe");
    }
}
