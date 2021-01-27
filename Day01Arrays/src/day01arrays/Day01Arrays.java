package day01arrays;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Day01Arrays {

    public static boolean isPrime(int number) {
        int sqrt = (int) Math.sqrt(number) + 1;

        for (int i = 2; i < sqrt; i++) {
            if (number % i == 0) { // number is perfectly divisible - no prime
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = 0;
        try {
            System.out.println("Please enter the size of Array(1 or greater):");
            size = scanner.nextInt();
            if (size < 1) {
                System.out.println("the size should be greater than 1");
                return;

            }
        

        int[] array1 = new int[size];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = (int) (Math.random() * 100 + 1);

        }
        for (int i = 0; i < array1.length; i++) {
            System.out.printf("%s%d", i == 0 ? "" : ",", array1[i]);

        }
        System.out.println();
        boolean isFirst=true;
        for (int i = 0; i < array1.length; i++) {
            if (isPrime(array1[i])) {
                System.out.printf("%s%d", isFirst? "" : ",", array1[i]);
                isFirst=false;
            }
       }
        System.out.println();
        } catch (InputMismatchException ex) {
            System.out.println("Mismatch error!");
        }
    }

}
