package repo;

import connection.EntityManagerFactory;
import entity.Continents;
import jakarta.persistence.Query;

import java.math.BigInteger;
import java.util.List;

public class ContinentsRepo extends AbstractRepo {
    public void printAll() {

        try {

            String sql = "SELECT continent FROM Continents continent";

            Query query = EntityManagerFactory.getEntityManager().createQuery(sql);
            List<Continents> continents = query.getResultList();

            for (Continents continent : continents) {
                System.out.printf("%d ", continent.getId());
                System.out.printf("%s ", continent.getName());
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void findById(int id) {

        try {

            String sql = "select continent from Continents continent where continent.id='" + id + "'";

            Query query = EntityManagerFactory.getEntityManager().createQuery(sql);
            List<Continents> continents = query.getResultList();

            for (Continents continent : continents) {
                System.out.printf("%d ", continent.getId());
                System.out.printf("%s ", continent.getName());
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void findByName(String name) {

        try {

            Query query = EntityManagerFactory.getEntityManager().createNamedQuery("findByName").setParameter("name",name);
            List<Continents> continents = query.getResultList();

            for (Continents continent : continents) {
                System.out.printf("%d ", continent.getId());
                System.out.printf("%s ", continent.getName());
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void create(int id, String name) {
        Continents continent = new Continents();
        continent.setId(BigInteger.valueOf(id));
        continent.setName(name);
        EntityManagerFactory.getEntityManager().persist(continent);
        EntityManagerFactory.getEntityManager().getTransaction().commit();
    }
}
