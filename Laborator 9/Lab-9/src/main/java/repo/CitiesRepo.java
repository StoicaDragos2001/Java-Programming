package repo;

import connection.EntityManagerFactory;
import entity.Cities;
import jakarta.persistence.Query;

import java.math.BigInteger;
import java.util.List;

public class CitiesRepo extends AbstractRepo {
    public void printAll() {

        try {

            String sql = "SELECT city FROM Cities city";

            Query query = EntityManagerFactory.getEntityManager().createQuery(sql);
            List<Cities> cities = query.getResultList();

            for (Cities city : cities) {
                System.out.printf("%d ", city.getId());
                System.out.printf("%s ", city.getName());
                System.out.printf("%d ", city.getCapital());
                System.out.printf("%s ", city.getCountry());
                System.out.printf("%s ", city.getLatitude());
                System.out.printf("%s ", city.getLongitude());
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void findById(int id) {

        try {

            String sql = "select city from Cities city where city.id='" + id + "'";

            Query query = EntityManagerFactory.getEntityManager().createQuery(sql);
            List<Cities> cities = query.getResultList();

            for (Cities city : cities) {
                System.out.printf("%d ", city.getId());
                System.out.printf("%s ", city.getName());
                System.out.printf("%d ", city.getCapital());
                System.out.printf("%s ", city.getCountry());
                System.out.printf("%s ", city.getLatitude());
                System.out.printf("%s ", city.getLongitude());
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void findByName(String name) {

        try {

            Query query = EntityManagerFactory.getEntityManager().createNamedQuery("findByName").setParameter("name", name);
            List<Cities> cities = query.getResultList();

            for (Cities city : cities) {
                System.out.printf("%d ", city.getId());
                System.out.printf("%s ", city.getName());
                System.out.printf("%d ", city.getCapital());
                System.out.printf("%s ", city.getCountry());
                System.out.printf("%s ", city.getLatitude());
                System.out.printf("%s ", city.getLongitude());
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void create(int id, String name, String country, int capital, String latitude, String longitude) {
        Cities city = new Cities();
        city.setId(BigInteger.valueOf(id));
        city.setName(name);
        city.setCountry(country);
        city.setCapital(BigInteger.valueOf(capital));
        city.setLatitude(latitude);
        city.setLongitude(longitude);
        EntityManagerFactory.getEntityManager().persist(city);
        EntityManagerFactory.getEntityManager().getTransaction().commit();
    }
}
