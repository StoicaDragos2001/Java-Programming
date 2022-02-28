import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Nu sunt suficiente argumente");
        } else {
            Read object1 = new Read();
            int n, p;
            String litere;
            System.out.println(object1.validateN(args));
            n = object1.validateN(args);
            System.out.println(object1.validateP(args));
            p = object1.validateP(args);
            System.out.println(object1.validateAlphabet(args));
            litere = object1.validateAlphabet(args);
            if(n!=-1 && p!=-1 && litere!="eroare: caracterele introduse nu sunt litere" && litere!="eroare: se repeta literele din alfabetul dat") {
                Words object2 = new Words();
                object2.create(n, p, litere);
            }
        }
    }
}
