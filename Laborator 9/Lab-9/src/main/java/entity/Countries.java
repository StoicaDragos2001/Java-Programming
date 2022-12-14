package entity;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.List;

@Entity
public class Countries {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private BigInteger id;
    @Basic
    @Column(name = "NAME")
    private String name;
    @Basic
    @Column(name = "CODE")
    private BigInteger code;
    @Basic
    @Column(name = "CONTINENT")
    private String continent;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getCode() {
        return code;
    }

    public void setCode(BigInteger code) {
        this.code = code;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Countries countries = (Countries) o;

        if (id != null ? !id.equals(countries.id) : countries.id != null) return false;
        if (name != null ? !name.equals(countries.name) : countries.name != null) return false;
        if (code != null ? !code.equals(countries.code) : countries.code != null) return false;
        if (continent != null ? !continent.equals(countries.continent) : countries.continent != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (continent != null ? continent.hashCode() : 0);
        return result;
    }

    @OneToMany
    private List<Cities> oneToMany;

    public List<Cities> getOneToMany() {
        return oneToMany;
    }

    public void setOneToMany(List<Cities> oneToMany) {
        this.oneToMany = oneToMany;
    }
}
