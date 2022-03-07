/**
 * Clasa Router
 * @author Petrea Daniela
 */

public class Router extends Node implements Identifiable{
    private String address;

    Router(String name) {
        super(name);
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Router{" +
                "name='" + name +
                "'}";
    }

}