/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day02arraysearch;

/**
 *
 * @author heshmat
 */
public class Day02ArraySearch {

    static int getIfExists(int[][] data, int row, int col) {
//        if ((row < data.length && row >= 0) && (col < data[0].length && col >= 0)) {
try{
            return data[row][col];
        }catch (ArrayIndexOutOfBoundsException ex)//if statement is better practice
        {
        return 0;
        }
    }

    static int sumOfCross(int[][] data, int row, int col) {
        return getIfExists(data, row, col) + getIfExists(data, row, col - 1) + getIfExists(data, row + 1, col) + getIfExists(data, row, col + 1) + getIfExists(data, row - 1, col);
        // return sum of the element at row/col
        // plus (if they exist) element above, below, to the left and right of it

    }

    static int minsumOfCross(int[][] data) {
        int min =sumOfCross(data, 0, 0);
        int l,m;
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
               if (min > sumOfCross(data, row, col)) {
                    min = sumOfCross(data, row, col);
                       }
//System.out.printf("%d   %d  \n",row,col);
            }
        }
        return min;
    }
    // useful helper for debuggin
static int[][]  data2DSum(int [][] data){
    int[][] data2dSum=new int[data.length][data[0].length];
    for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
             data2dSum[row][col]=sumOfCross(data,row,col);
//System.out.printf("%d   %d  \n",row,col);
            }
        }
    return  data2dSum;
}
    static void print2D(int[][] data) {
         for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
              System.out.printf("%s%d",col==0?"":",",data[row][col]);
//System.out.printf("%d   %d  \n",row,col);
            }
            System.out.println();
        }
    }
    //jagged Array
    static int[][] duplicateEmptyArray2D(int [][] orig2d){
        int[][] result=new int[orig2d.length][];
        for(int row=0;row<orig2d.length;row++){
            int rowLength=orig2d[row].length;
            result[row]=new int[rowLength];
        }
        return result;
    }
        

    // you may not need it: static int[][] duplicateArray2D(int[][] orig2d) { ... }
    public static void main(String[] args) {
        int[][] data2D = {
            {1, 3, 6},
            {7, 1, 2, 3},
            {8, 3, 2},
            {1, 7, 1, 9},
        };
        int[][] cross2D=duplicateEmptyArray2D(data2D);
        System.out.println(getIfExists(data2D, 6, 2));

        System.out.println(sumOfCross(data2D, 0, 0));

        System.out.println(minsumOfCross(data2D));
          for (int row = 0; row < data2D.length; row++) {
            for (int col = 0; col < data2D[row].length; col++) {
                cross2D[row][col] = sumOfCross(data2D, row, col);
            }
        }
       
       print2D(data2D);
        print2D(cross2D);
        
         //print2D(duplicateArray2D(data2D));
    }

}
