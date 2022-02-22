package Java;

public class sumofdigits {
    public int sumdigits(int n) {
        int digit, sum = 0;
        while (n > 9) {
            while (n > 0) {
                digit = n % 10;
                n = n / 10;
                sum = sum + digit;
            }
            n = sum;
            sum = 0;
        }
        return n;
    }
}
