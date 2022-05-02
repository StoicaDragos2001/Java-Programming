package manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Manager {
    private final EntityManagerFactory factory;
    private final EntityManager manager;
    private static Manager managerInstance = null;

    private Manager() {
        this.factory = Persistence.createEntityManagerFactory("Lab9-Compulsory");
        this.manager = factory.createEntityManager();
    }

    public static Manager getInstance() {
        if (managerInstance == null) {
            managerInstance = new Manager();
            managerInstance.getManager().getTransaction().begin();
        }

        return managerInstance;
    }

    public EntityManager getManager() {
        return manager;
    }
    public static void closeManager() {
        Manager.getInstance().getManager().close();
    }
}