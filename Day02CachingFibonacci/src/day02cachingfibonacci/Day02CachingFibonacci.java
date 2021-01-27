package day02cachingfibonacci;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Day02CachingFibonacci {

   static class FibCached {

        private ArrayList<Long> fibsCached = new ArrayList<>(); // NOT a HashMap !
        private int fibsCompCount = 2;
         private int fibsFromCacheCount = 0;

        FibCached() {
            fibsCached.add(0L); // #0
            fibsCached.add(1L); // #1
        }

        // in a correct caching implementation fibsCompCount will end up the same as fibsCached.size();
        public long getNthFib(int n) {
            //n--;//start index from 1
            if (n < 1) {
                throw new IllegalArgumentException("Index can not be less than 1");
            }
            return computeNthFib(n);
        }
            private long computeNthFibForLoop(int n) {
        for (int i = fibsCached.size(); i <= n; i++) {
            long val = fibsCached.get(i-1) + fibsCached.get(i-2);
            fibsFromCacheCount += 2;
            fibsCached.add(val);
            fibsCompCount++;
        }
        return fibsCached.get(n);
    }
    
        // You can find implementation online, recursive or non-recursive.
        // For 100% solution you should use values in fibsCached as a starting point
        // instead of always starting from the first two values of 0, 1.
        private long computeNthFib(int n) {
            if (n >= fibsCached.size()) {
                fibsCached.add(computeNthFib(n - 1) + computeNthFib(n - 2));
                fibsCompCount++;
            }
            return fibsCached.get(n);
        }
          public int getCountOfFibsComputed() {
        return fibsCompCount;
    }

        // You are allowed to add another private method for fibonacci generation
        // if you want to use recursive approach. I recommend non-recursive though.
        // How many fibonacci numbers has your code computed as opposed to returned cached?
        // Use this in your testing to make sure your caching actually works properly.
     
          @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (long l : fibsCached) {

            sb.append(l == 0 ? "" : ", ");
            sb.append(l);
        }
        return sb.toString();
    }// returns all cached Fib values, comma-space-separated on a single line

    }// end class fibonachi
     static Scanner input = new Scanner(System.in);
    static FibCached f = new FibCached();

    static int getInt() {
        int value = -1;
        while (true) {
            try {
                value = input.nextInt();
                return value;
            } // end try
            catch (InputMismatchException e) {
                input.next(); // consume the wrong value
                System.out.println("Enter an integer: ");
            } // catch
        } // end while
    } //end method getInt

    static void GetFibByIndex() {
        while(true){
        System.out.println("Enter the number to find nth Fibonacci number:");
        try {
            int nth = getInt();
            System.out.printf("%dth Fibonacci number is: %d\n", nth, f.getNthFib(nth));
            break;

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        }
    }
    public static void main(String[] args) {
         while (true) {
            GetFibByIndex();
            System.out.println("Steps: " + f.getCountOfFibsComputed());
            System.out.println("Cash: "+f.toString());
        }
    }

}
