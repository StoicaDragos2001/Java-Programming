// Stoica Dragos-Stefan 2A5

public class Main {
    public Main() {
    }

    public static int Compute(int n) {
        for(int s = 0; n >= 10; s = 0) {
            while(n != 0) {
                int m = n % 10;
                n /= 10;
                s += m;
            }

            n = s;
        }

        System.out.println(n);
        return n;
    }

    public static void Compulsory() {
        System.out.println("Hello World!!");
        String[] languages = new String[]{"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        System.out.println(languages[3]);
        int n = (int)(Math.random() * 1000000.0D);
        System.out.println(n);
        n *= 3;
        System.out.println(n);
        String bin_string = "10101";
        int bin_to_int = Integer.parseInt(bin_string, 2);
        n += bin_to_int;
        System.out.println(n);
        String hex_string = "FF";
        int hex_to_int = Integer.parseInt(hex_string, 16);
        n += hex_to_int;
        System.out.println(n);
        n *= 6;
        System.out.println(n);

        for(int s = 0; n >= 10; s = 0) {
            while(n != 0) {
                int m = n % 10;
                n /= 10;
                s += m;
            }

            n = s;
        }

        int result = Compute(n);
        System.out.print("Willy-nilly, this semester I will learn " + languages[result]);
    }

    public static void main(String[] args) {
        Compulsory();
    }
}
