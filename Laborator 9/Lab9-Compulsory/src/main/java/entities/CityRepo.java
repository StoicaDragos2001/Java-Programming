package entities;

import javax.persistence.EntityManager;
import java.util.List;

public class CityRepo extends Repo<City> {

    public CityRepo() {
        super();
    }

    public City findByID(String id) {

        City city = manager.find(City.class, id);
        manager.getTransaction();
        return city;

    }


    public List<City> findByName(String name) {
        List<City> citiesFound = (List<City>) manager.createNamedQuery("Cties.findByName")
                .setParameter("title", name)
                .getResultList();
        return citiesFound;
    }

    public static void setManager(EntityManager manager) {
        CityRepo.manager = manager;
    }

    public static void closeManager() {
        manager.close();
    }
}