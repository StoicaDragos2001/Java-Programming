public class Bonus {
    //Stoica Dragos-Stefan 2A5
    int largestK;
    int p1, p2, start, end;
    int n1;
    String[] words1;

    public void showSubset() {
        System.out.print("Largest subset found: ");
        if (start > end) {
            for (int i = start; i <= n1 - 1; i++) {
                System.out.print(words1[i] + " ");
                largestK++;
            }
            for (int i = 0; i <= end; i++) {
                System.out.print(words1[i] + " ");
                largestK++;
            }
            System.out.println("");
        } else {
            for (int i = p1; i <= p2; i++) {
                System.out.print(words1[i] + " ");
                largestK++;
            }
            System.out.println("");
        }
    }


    public void subsetCalculator(boolean[][] matrixx, String[] words, int n) {
        n1 = n;
        words1 = words;
        int lg = 0;
        int k = 0;
        int maxlg = 0;
        while (k < n - 1) {
            if (matrixx[k][k + 1]) {
                end++;
                lg = end - start + 1;
                if (lg > maxlg) {
                    maxlg = lg;
                    p1 = start;
                    p2 = end;
                }
            } else {
                start = k + 1;
                end = k + 1;
            }
            k++;
        }

        k = start;
        int ok = 0;
        if (matrixx[n - 1][0]) {
            ok = 1;
        }
        if (ok == 1) {
            int smth = 0;
            end = 0;
            while (smth < n-1 && matrixx[smth][smth + 1]) {
                end++;
                lg++;
                if (lg > maxlg) {
                    maxlg = lg;
                    p1 = start;
                    p2 = end;
                }
                smth++;
            }
        }
    }

    public int getLargestK() {
        return largestK;
    }
}
