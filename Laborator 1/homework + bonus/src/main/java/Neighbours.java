public class Neighbours {
    //Stoica Dragos-Stefan 2A5
    public boolean[][] matrix;
    public String[][] neighbours;
    public String[] vec;

    public void fillNeighbours(int i, int neighboursCount){
        neighbours[i] = new String[neighboursCount];
        for (int a = 0; a < neighboursCount; a++)
            neighbours[i][a] = vec[a];

    }

    public void Fill(int n, String[] words) {
        matrix = new boolean[n][n];
        neighbours = new String[n][];
        for (int i = 0; i < n; i++) {
            int neighboursCount = 0;
            vec = new String[n];
            for (int j = 0; j < n; j++) {
                boolean test = false;
                if (i != j) {
                    for (int l = 0; l < words[i].length(); l++) {
                        for (int s = 0; s < words[j].length(); s++)
                            if (words[i].charAt(l) == words[j].charAt(s)) {
                                test = true;
                                matrix[i][j] = true;
                                break;
                            }
                    }
                }
                if (test) {
                    vec[neighboursCount] = words[j];
                    neighboursCount++;
                }
            }
            fillNeighbours(i,neighboursCount);
        }
    }

    public void ShowNeighbours(int n, String[] words) {
        for (int i = 0; i < n; i++) {
            System.out.print("Vecini pentru cuvantul " + words[i] + ": ");
            for (String s : neighbours[i])
                System.out.print(s + " ");
            System.out.println("");
        }
    }

    public boolean[][] getMatrix(){
        return matrix;
    }
}
