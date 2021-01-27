/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day01universalarrays;

import java.awt.RenderingHints;
import java.time.temporal.Temporal;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author heshmat
 */
public class Day01UniversalArrays {

    static Scanner input = new Scanner(System.in);
 static int getInt() {
        int value = -1;
        while (true) {
            try {
                value = input.nextInt();
                return value;
            } // end try
            catch (InputMismatchException e) {
                input.next(); // consume the wrong value
                System.out.println(e.getMessage());
                System.out.println("Enter an integer: ");
            } // catch
        } // end while
    } //end method getInt
    static void inputArray(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.printf("enter item #%d ", i+1);
            data[i] = getInt();
        }

    } // single dimensional

    static void inputArray(int[][] data2) {
        for (int i = 0; i < data2.length; i++) {
            for (int j = 0; j < data2[i].length; j++) {
                System.out.printf("Enter value row %d column %d : ", i+1, j+1);
                data2[i][j] = getInt();
            }
        }

    } // two dimensional, could be *jagged* array

    static void printArray(int[] data) {
        System.out.println("data1(single dimentional): ");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%s%d ", i == 0 ? "" : ",", data[i]);
        }
        System.out.println();
    } // print on a single line, comma-separated

    static void printArray(int[][] data2) {
       
        for (int i = 0; i < data2.length; i++){
           for (int j = 0; j < data2[i].length; j++) {
                System.out.printf("%s%d", j==0 ? "" : ",", data2[i][j]);
              
            }
            System.out.println();
        }
    } // could be a *jagged* array
     static void printArrayAdv(int[][] data2d) {
        // find the maximum row length
        int maxRowLength = data2d[0].length;
        for (int row = 0; row < data2d.length; row++) {
            if (data2d[row].length > maxRowLength) {
                maxRowLength = data2d[row].length;
            }
        }
        // get columns width
        var columnsWidth = new int[maxRowLength];
        for (int row = 0; row < data2d.length; row++) {
            for (int col = 0; col < data2d[row].length; col++) {
                // columnsWidth[col] = 0; // array is all 0's when allocated, no need
                int length = String.valueOf(data2d[row][col]).length();
                if (columnsWidth[col] < length) {
                    columnsWidth[col] = length;
                }
            }
        }
        // printArray(columnsWidth);
        // Print Array
        System.out.println();
        for (int row = 0; row < data2d.length; row++) {
            for (int col = 0; col < data2d[row].length; col++) {
                System.out.printf("%s%" + columnsWidth[col] + "d", col == 0 ? "" : ", ", data2d[row][col]);
            }
            System.out.println();
        }
    }

    static int[] findDuplicatesV2(int[] a1, int[] a2) {
        int[] dups = new int[Math.min(a1.length, a2.length)];
        int dupsFound = 0;
        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a2.length; j++) {
                if (a1[i] == a2[j]) {
                    // duplicate found, let's make sure it's unique
                    boolean isUnique = true;
                    for (int k = 0; k < dupsFound; k++) {
                        if (dups[k] == a1[i]) {
                            isUnique = false; // already in dups
                            break;
                        }
                    }
                    if (isUnique) {
                        dups[dupsFound] = a1[i];
                        dupsFound++;
                    }
                }
            }
        }
          int[] finalDups = new int[dupsFound];
        for (int i = 0; i < dupsFound; i++) {
            finalDups[i] = dups[i];
        }
        return finalDups;
    }
     static int[] removeDupsV2(int[] a1) {
        int[] uniq = new int[a1.length];
        int uniqFound = 0;
        for (int i = 0; i < a1.length; i++) {
            boolean isUnique = true;
            for (int k = 0; k < uniqFound; k++) {
                if (uniq[k] == a1[i]) {
                    isUnique = false; // already in dups
                    break;
                }
            }
            if (isUnique) {
                uniq[uniqFound] = a1[i];
                uniqFound++;
            }
        }
        //
        int[] finalDups = new int[uniqFound];
        for (int i = 0; i < uniqFound; i++) {
            finalDups[i] = uniq[i];
        }
        return finalDups;
    }
  static int[] joinV2(int[] a1, int[] a2) {
        var joinArr = new int[a1.length + a2.length];
        for (int i = 0; i < a1.length; i++) {
            joinArr[i] = a1[i];
        }
        for (int i = 0; i < a2.length; i++) {
            joinArr[i + a1.length] = a2[i];
        }
        return joinArr;
    }    

    static int[] joinV3(int[] a1, int[] a2) {
        var joinArr = new int[a1.length + a2.length];
        int idx = 0;
        for (int i = 0; i < a1.length; i++) {
            joinArr[idx++] = a1[i];
        }
        for (int i = 0; i < a2.length; i++) {
            joinArr[idx++] = a2[i];
        }
        return joinArr;
    }
    
    static int[] join(int[] a1, int[] a2) {
        var joinArr = new int[a1.length + a2.length];
        for (int i = 0; i < a1.length; i++) {
            joinArr[i] = a1[i];
        }
        int k = a1.length;
        for (int j = 0; j < a2.length; j++) {
            joinArr[k] = a2[j];
            k++;
        }
        return joinArr;
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] data1 = new int[5];
        int[][] data2 = new int[2][3];
        // inputArray(data1);
        // inputArray(data2);
        // printArray(data1);
        // printArray(data2);
        int[] a1 = {2, 4, 4, 2, 4};
        int[] a2 = {4, 2, 1, 0, 4};
       
         int[] a3=findDuplicatesV2(a1, a2);
         for(int i=0;i<a3.length;i++)
         {
             System.out.printf("%d ,",a3[i]);
         }
    }

}
