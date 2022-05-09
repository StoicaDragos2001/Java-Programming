package entity;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
public class Cities {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private BigInteger id;
    @Basic
    @Column(name = "COUNTRY")
    private String country;
    @Basic
    @Column(name = "NAME")
    private String name;
    @Basic
    @Column(name = "CAPITAL")
    private BigInteger capital;
    @Basic
    @Column(name = "LATITUDE")
    private String latitude;
    @Basic
    @Column(name = "LONGITUDE")
    private String longitude;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getCapital() {
        return capital;
    }

    public void setCapital(BigInteger capital) {
        this.capital = capital;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cities cities = (Cities) o;

        if (id != null ? !id.equals(cities.id) : cities.id != null) return false;
        if (country != null ? !country.equals(cities.country) : cities.country != null) return false;
        if (name != null ? !name.equals(cities.name) : cities.name != null) return false;
        if (capital != null ? !capital.equals(cities.capital) : cities.capital != null) return false;
        if (latitude != null ? !latitude.equals(cities.latitude) : cities.latitude != null) return false;
        if (longitude != null ? !longitude.equals(cities.longitude) : cities.longitude != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (capital != null ? capital.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        return result;
    }
}
