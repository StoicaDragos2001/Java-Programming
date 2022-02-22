package Java;

public class calculations {
    public int calcul(int n){
        n *=3;
        String binary = "10101";
        n = n + Integer.parseInt(binary, 2);
        String hex = "FF";
        n = n + Integer.parseInt(hex, 16);
        n *=6;
        return n;
    }
}
