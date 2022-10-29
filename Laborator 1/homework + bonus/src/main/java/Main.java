import static java.lang.Integer.parseInt;

public class Main {
    //Stoica Dragos-Stefan 2A5
    public static void checkEntry(String[] args) {
        if (args.length < 3) {
            System.out.println("Not enough arguments given");
            System.exit(0);
        }
        if (!Validate.ValidateInteger(args[0])) {
            System.out.println("First argument is not integer");
            System.exit(0);
        }
        if (!Validate.ValidateInteger(args[1])) {
            System.out.println("Second argument is not integer");
            System.exit(0);
        }

        for (int i = 2; i < args.length; i++) {
            if (Validate.ValidateInteger(args[i]) || !args[i].matches("[a-zA-Z]+") || args[i].length() > 1) {
                System.out.println("C1...Cm are not sets of letters");
                System.exit(0);
            }
            for (int j = i + 1; j < args.length; j++)
                if (args[i].equals(args[j])) {
                    System.out.println("Duplicates in alphabet");
                    System.exit(0);
                }
        }
        System.out.println("Valid arguments!");
    }


    public static void main(String[] args) {
        final long startTime = System.nanoTime();

        checkEntry(args);
        Creator app = new Creator();
        app.Filler(args);
        int n = app.getN();
        String[] words = app.generate();
        for (int i = 0; i < n; i++)
            System.out.print(words[i] + " ");
        System.out.println("");

        Neighbours data = new Neighbours();
        data.Fill(n, words);
        if (n < 150)
            data.ShowNeighbours(n, words);

        boolean[][] matrixx = data.getMatrix();

        Bonus algo = new Bonus();
        algo.subsetCalculator(matrixx,words,n);
        algo.showSubset();
        System.out.println("Largest K length: " + algo.getLargestK());

        final long duration = System.nanoTime() - startTime;
        System.out.println(duration + " nanoseconds");

    }
}
