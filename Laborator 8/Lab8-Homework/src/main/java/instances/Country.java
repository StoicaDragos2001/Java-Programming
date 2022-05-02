package instances;

public class Country {
    private int id;
    private String name;
    private int code;
    private String continent;

    Country(int id, String name, int code, String continent) {
        setId(id);
        setName(name);
        setCode(code);
        setContinent(continent);
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

    public int getCode() {
        return code;
    }

    public String getContinent() {
        return continent;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }
}