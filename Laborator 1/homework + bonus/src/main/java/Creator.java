import java.util.Arrays;

import static java.lang.Integer.parseInt;

public class Creator {
    //Stoica Dragos-Stefan 2A5
    private int n;
    public int p, alphabetSize;
    public String alphabet;

    public void Filler(String[] args) {
        n = parseInt(args[0]);  //number of words
        p = parseInt(args[1]);  //number of characters/word
        alphabetSize = args.length - 2;
        alphabet = "";
        for(int i=2; i<args.length;i++)
            alphabet+=args[i];
    }

    public String[] generate() {
        String[] words = new String[n];
        StringBuilder sb = new StringBuilder(p);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                int place = (int) (alphabetSize * Math.random());
                sb.append(alphabet.charAt(place));
            }
            words[i] = sb.toString();
            sb.setLength(0);
        }
        return words;
    }

    public int getN(){
        return n;
    }
}
