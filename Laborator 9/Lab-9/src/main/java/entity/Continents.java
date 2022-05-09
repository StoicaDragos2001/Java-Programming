package entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name="Continents")
@NamedQueries({
        @NamedQuery(name = "findByName",
                query = "select e from Continents e where e.name = :name"),
})

public class Continents implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private BigInteger id;
    @Basic
    @Column(name = "NAME")
    private String name;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Continents that = (Continents) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany
    private List<Countries> oneToMany;

    public List<Countries> getOneToMany() {
        return oneToMany;
    }

    public void setOneToMany(List<Countries> oneToMany) {
        this.oneToMany = oneToMany;
    }
}
