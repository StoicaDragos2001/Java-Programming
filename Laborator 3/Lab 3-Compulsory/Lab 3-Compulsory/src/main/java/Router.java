

/**
 * Clasa Router
 *
 * @author Petrea Daniela
 */
/**
 * nodul de tip Router poate fi identificat prin adresa
 */
public class Router extends Node implements Identifiable {
    private String address;

    Router(String name, String address) {
        super(name);
        setAddress(address);
    }

    public void setAddress(String address) {
        this.address = address;
    }
    /**
     * suprascriem metoda getAddress din interfata Identifiable
     * @return adresa
     */
    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Router{" +
                "name=" + getName() + " address=" + getAddress() + " }";
    }

}