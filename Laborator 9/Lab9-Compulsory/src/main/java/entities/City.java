package entities;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Table(name = "cities")
@NamedQueries({
        @NamedQuery(name = "City.findAll",
                query = "select e from City e order by e.name"),
        @NamedQuery(name = "City.findByCountry",
                query = "select e from City e where e.country = ?1"),
        })
public class City {
    private int id;
    private String country;
    private String name;
    private int capital;
    private String latitude;
    private String longitude;

    City(int id, String country, String name, int capital, String latitude, String longitude) {
        setId(id);
        setCountry(country);
        setName(name);
        setCapital(capital);

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public int getCapital() {
        return capital;
    }


    public String getCountry() {
        return country;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}