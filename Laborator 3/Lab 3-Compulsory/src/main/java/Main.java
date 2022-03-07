import java.util.*;
public class Main {
    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();

        nodes.add(new Computer("v1"));
        nodes.add(new Router("v2"));
        nodes.add(new Switch("v3"));
        nodes.add(new Switch("v4"));
        nodes.add(new Router("v5"));
        nodes.add(new Computer("v6"));

        System.out.println(nodes);
    }
}

