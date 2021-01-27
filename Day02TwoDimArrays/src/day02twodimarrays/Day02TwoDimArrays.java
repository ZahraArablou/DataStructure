package day02twodimarrays;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Day02TwoDimArrays {

    public static boolean isPrime(int number) {
        int sqrt = (int) Math.sqrt(number) + 1;
if(number<1)return false;
        for (int i = 2; i < sqrt; i++) {
            if (number % i == 0) { // number is perfectly divisible - no prime
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int width = 0;
        int height = 0;
        try {
            System.out.println("enter the width(1 and greater)");
            width = input.nextInt();
            System.out.println("enter the heigth(1 and greater)");
            height = input.nextInt();
            if (width < 1 || height < 1) {
                System.out.println("the numbers should be greater than 1");
                return;
            }
        } catch (InputMismatchException ex) {
            System.out.println("Invalid data input");
        }

        int[][] data = new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                data[i][j] = -100 + (int) (Math.random() * (100 - (-100)) + 1);
            }
        }
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                System.out.printf("%s%d ", j == 0 ? "" : ",", data[i][j]);
            }
            System.out.println("");
        }
        //sum of all numbers in array
        int sum = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                sum += data[i][j];
            }

        }
        int sum1 = sum;
        System.out.println("sum of all numbers is: " + sum);

        //Sum of each of the row of the array
        sum = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                sum += data[i][j];
            }
            System.out.printf("sum of all numbers in row %d: %d\n ", i, sum);
            System.out.println("****************");

            sum = 0;
        }
        // Sum of each of the column of the array
        sum = 0;
        for (int i = 0; i < data[0].length; i++) {
            for (int j = 0; j < data.length; j++) {
                sum += data[j][i];
            }
            System.out.printf("sum of all numbers in column %d: %d\n ", i, sum);
            sum = 0;
        }
        System.out.println("****************");

        //Standard deviation of all numbers in the array
        //m =sum1 /data[0].length * data.length;
        double avg;
        double sumofSquares = 0;
        avg = (double) sum1 / (data[0].length * data.length);

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                sumofSquares += Math.pow((data[i][j] - avg), 2);
            }

        }
        double variance = sumofSquares / (data[0].length * data.length);

        double stdDev = Math.sqrt(variance);
        System.out.printf("Deviation is %.3f\n", stdDev);

        //5) Find pairs of numbers in the array whose sum is a prime number and display those pairs and their sum.
        System.out.println("*************************");
         
        // find pairs of numbers whose sum is a prime number with out duplicate
   
        for (int rowA = 0; rowA < data.length; rowA++) {
            for (int colA = 0; colA < data[rowA].length; colA++) {
                //
                int valA = data[rowA][colA];
                for (int rowB = rowA; rowB < data.length; rowB++) {
                    for (int colB = 0; colB < data[rowB].length; colB++) {
                        if (rowB == rowA && colB <= colA) { // skip it
                            continue;
                        }
                        int valB = data[rowB][colB];
                        int sumOfPair = valA + valB;
                        if (isPrime(sumOfPair)) {
                            System.out.printf("Prime sum %d of [%d,%d]+[%d,%d]\n", sumOfPair, rowA, colA, rowB, colB);
                        }
                    }
                }
                
            }
        }
    

    // find pairs of numbers whose sum is a prime number with duplicate
   
        for (int rowA = 0; rowA < data.length; rowA++) {
            for (int colA = 0; colA < data[rowA].length; colA++) {
                //
                int valA = data[rowA][colA];
                for (int rowB = 0; rowB < data.length; rowB++) {
                    for (int colB = 0; colB < data[rowB].length; colB++) {
                        if (rowB == rowA && colB == colA) { // skip it, don't match with itself
                            continue;
                        }
                        int valB = data[rowB][colB];
                        int sumOfPair = valA + valB;
                        if (isPrime(sumOfPair)) {
                            System.out.printf("Prime sum %d of [%d,%d]+[%d,%d]\n", sumOfPair, rowA, colA, rowB, colB);
                        }
                    }
                }
                
            }
        }
   
       
        System.out.println("");
    }
     

}
