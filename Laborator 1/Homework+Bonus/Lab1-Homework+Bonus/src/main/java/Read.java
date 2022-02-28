import java.lang.*;

public class Read {
    public boolean isStringInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public int validateN(String[] array) {
        if (isStringInt(array[0])) {
            int n = Integer.parseInt(array[0]);
            if (n >= 0)
                return n;
            else
                return -1;
        } else {
            System.out.println("nu e de tip int");
            return -1; // codul meu de eroare
        }
    }

    public int validateP(String[] array) {
        if (isStringInt(array[1])) {
            int p = Integer.parseInt(array[1]);
            if (p >= 0)
                return p;
            else
                return -1;
        } else {
            System.out.println("nu e de tip int");
            return -1; // codul meu de eroare
        }
    }

    boolean unique(String str) {
        for (int i = 0; i < str.length(); i++)
            for (int j = i + 1; j < str.length(); j++)
                if (str.charAt(i) == str.charAt(j))
                    return false;
        return true;
    }


    public String validateAlphabet(String[] array) {
        String letters = "";
        int m = 0;
        for (int j = 2; j < array.length; j++) {
            if (Character.isLetter(array[j].charAt(0)) && (array[j].length() == 1)) {
                letters += array[j].charAt(0);
                m = 1;
            }
        }
        if (m == 0) {
            return ("eroare: caracterele introduse nu sunt litere");
        }
        if (unique(letters))
            return letters;
        else
            return ("eroare: se repeta literele din alfabetul dat");

    }
}