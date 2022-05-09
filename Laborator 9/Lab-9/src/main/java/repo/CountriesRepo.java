package repo;

import connection.EntityManagerFactory;
import entity.Countries;
import jakarta.persistence.Query;

import java.math.BigInteger;
import java.util.List;

public class CountriesRepo extends AbstractRepo {
    public void printAll() {

    try {

        String sql = "SELECT country FROM Countries country";

        Query query = EntityManagerFactory.getEntityManager().createQuery(sql);
        List<Countries> countries = query.getResultList();

        for (Countries country : countries) {
            System.out.printf("%d ", country.getId());
            System.out.printf("%s ", country.getName());
            System.out.printf("%d ", country.getCode());
        }

    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}

    public void findById(int id) {

        try {

            String sql = "select country from Countries country where country.id='" + id + "'";

            Query query = EntityManagerFactory.getEntityManager().createQuery(sql);
            List<Countries> countries = query.getResultList();

            for (Countries country : countries) {
                System.out.printf("%d ", country.getId());
                System.out.printf("%s ", country.getName());
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void findByName(String name) {

        try {

            Query query = EntityManagerFactory.getEntityManager().createNamedQuery("findByName").setParameter("name",name);
            List<Countries> countries = query.getResultList();

            for (Countries country : countries) {
                System.out.printf("%d ", country.getId());
                System.out.printf("%s ", country.getName());
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void create(int id, String name, int continentId) {
        Countries country = new Countries();
        country.setId(BigInteger.valueOf(id));
        country.setName(name);
        country.setCode(BigInteger.valueOf(continentId));
        EntityManagerFactory.getEntityManager().persist(country);
        EntityManagerFactory.getEntityManager().getTransaction().commit();
    }
}
