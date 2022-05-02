
import connection.Database;
import manager.Manager;

import javax.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
         Database.createConnection();
         EntityManager manager= Manager.getInstance().getManager();
    }
}
