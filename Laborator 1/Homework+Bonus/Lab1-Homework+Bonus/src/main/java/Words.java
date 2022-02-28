import java.util.Arrays;

public class Words {
    boolean twoStrings(String s1, String s2) {
        boolean v[] = new boolean[52];
        Arrays.fill(v, false);

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) >= 'a' && s1.charAt(i) <= 'z') {
                v[s1.charAt(i) - 'a'] = true;
            } else {
                v[s1.charAt(i) - 'A' + 26] = true;
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) >= 'a' && s2.charAt(i) <= 'z') {
                if (v[s2.charAt(i) - 'a'])
                    return true;
            } else {
                if (v[s2.charAt(i) - 'A' + 26])
                    return true;
            }
        }

        return false;
    }
    private static boolean check(int[] arr, int toCheckValue)
    {
        for (int element : arr) {
            if (element == toCheckValue) {
                return true;
            }
        }

       return false;
    }
    public int findLongestSub(String[] strArray) {
        int array[]=new int[strArray.length];
        for(int i=0;i<= array.length-1;i++)
            array[i]=-1;
        int count = 1, len = 1, max = 1,index=0;
        while (!(check(array,len-1))) {
            //System.out.println(len);
            if (twoStrings(strArray[len], strArray[len-1]) && !(strArray[len].equals(strArray[len-1]))) {
                count++;
                array[index]=len-1;
                index++;
              // System.out.println("count "+count);
            }
                if (max < count) {
                    max = count;
                }
           else {
                count = 1;
            }
            for(int i=0;i<= array.length-1;i++)
           // System.out.println(array[i]);
            len++;
            if(len== strArray.length)
                len=0;
        } ;
        return max;
    }



    public void bonus(boolean[][] mat, int n, String[] strArray) {
        int max = 0, row = 0;
        for (int i = 0; i < n; i++) {
            int sumRow = 0;
            for (int j = 0; j < n; j++) {
                int myInt = mat[i][j] ? 1 : 0;
                sumRow = sumRow + myInt;
            }
            if (sumRow > max) {
                max = sumRow;
                row = i;
            }
        }
        /*
        System.out.println("Subsirul cerut este ");
        for (int j = 0; j < n; j++) {
            if (mat[row][j])
                System.out.print(strArray[j] + " ");
        }
        */
    }


    public void create(int n, int p, String lettersArray) {
        boolean largeInput = false;
        long startTime = 0, endTime;
        if (n > 1000)
            largeInput = true;
        if (largeInput)
            startTime = System.nanoTime();
        String[] strArray = new String[n];
        StringBuilder sb = new StringBuilder(p);
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < p; i++) {
                int index = (int) (lettersArray.length() * Math.random());
                sb.append(lettersArray.charAt(index));
            }
            strArray[j] = sb.toString();
            sb.setLength(0);
        }
        if (!largeInput) {
            System.out.println("Cuvintele sunt");
            for (int j = 0; j < n; j++) {
                System.out.print(strArray[j]+" ");
            }
            System.out.println();
        }
        boolean[][] mat = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (twoStrings(strArray[i], strArray[j]) && !(strArray[i].equals(strArray[j])))
                    mat[i][j] = true;
            }
        }

        System.out.println("Matricea booleana este ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }

        String[] strArrayNeighbors = new String[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j]) {
                    if (strArrayNeighbors[i] == null) {
                        strArrayNeighbors[i] = strArray[j];
                        strArrayNeighbors[i] += " ";
                    } else {
                        strArrayNeighbors[i] += strArray[j];
                        strArrayNeighbors[i] += " ";
                    }
                }

            }
        }
        System.out.println("rez e ");
        System.out.println(findLongestSub(strArray));
        if (!largeInput) {
            for (int j = 0; j < n; j++) {
                System.out.println("Vecinii cuvantului " + strArray[j] + " sunt " + strArrayNeighbors[j]);
            }
        } else {
            endTime = System.nanoTime();
            System.out.printf("Total time in nanoseconds: %d\n", endTime - startTime);
        }

    }
}
