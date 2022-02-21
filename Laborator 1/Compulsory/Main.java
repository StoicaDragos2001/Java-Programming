package com.company;
import java.util.Scanner;    // Needed for Scanner class
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world");
        String languages[] = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        n *=3;
        String binary = "10101";
        n = n + Integer.parseInt(binary, 2);
        String hex = "FF";
        n = n + Integer.parseInt(hex, 16);
        n *=6;
        System.out.println(n);
        int digit, sum = 0;
        while(n>9){
            while (n > 0) {
                digit = n % 10;
                n = n / 10;
                sum = sum + digit;
            }
        n=sum;
        sum=0;
    }
        System.out.println(n);
        System.out.println("Willy-nilly, this semester I will learn " + languages[n]);
        int n1;
        int p;
        
        // Create a Scanner object to read input.
        Scanner console = new Scanner(System.in);

        // Get n1 from the user.
        System.out.print("Enter n1 ");
        n1 = console.nextInt();

        // Get p from the user.
        System.out.print("Enter p ");
        p = console.nextInt();

    }

}
