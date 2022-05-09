package connection;

import entity.Continents;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class EntityManagerFactory {
    private static jakarta.persistence.EntityManagerFactory entityManagerFactory = null;
    private static EntityManager entityManager = null;

    public static jakarta.persistence.EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public static EntityManager getEntityManager() {
        return entityManager;
    }

    public static void manager() {

        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

    }
}
