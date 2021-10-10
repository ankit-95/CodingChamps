package com.codingchamps.Sorting;


/*Counting sort is a sorting technique based on keys between a specific range.
It works by counting the number of objects having distinct key values (kind of hashing).
Then doing some arithmetic to calculate the position of each object in the output sequence.

        For simplicity, consider the data in the range 0 to 9.
        Input data: 1, 4, 1, 2, 7, 5, 2
        1) Take a count array to store the count of each unique object.
        Index:     0  1  2  3  4  5  6  7  8  9
        Count:     0  2  2  0   1  1  0  1  0  0

        2) Modify the count array such that each element at each index
        stores the sum of previous counts.
        Index:     0  1  2  3  4  5  6  7  8  9
        Count:     0  2  4  4  5  6  6  7  7  7

        The modified count array indicates the position of each object in
        the output sequence.

        3) Rotate the array clockwise for one time.
        Index:     0 1 2 3 4 5 6 7 8 9
        Count:     0 0 2 4 4 5 6 6 7 7

        4) Output each object from the input sequence followed by
        increasing its count by 1.
        Process the input data: 1, 4, 1, 2, 7, 5, 2. Position of 1 is 0.
        Put data 1 at index 0 in output. Increase count by 1 to place
        next data 1 at an index 1 greater than this index.

        Time Complexity : O (n + k)
        */


import java.util.Arrays;

public class CountingSort {

    public static void countSortForPositiveNumbersOnly(int ar[]) {
         int count[] = new int[255];
         int output[] = new int[ar.length];
         for(int i=0;i<255;i++){
             count[i] = 0;
         }

         for(int i=0;i<ar.length;i++){
             ++count[ar[i]];
         }

         for(int i=1;i<255;i++){
             count[i] += count[i-1];
         }

         for(int i=0;i<ar.length;i++){
             output[count[ar[i]]-1] = ar[i];
             --count[ar[i]];
         }

         Arrays.stream(output).forEach(e-> System.out.print(e+" "));
    }
    public static void countSortHandleNegativeNumbers(int ar[]){

        int max = Arrays.stream(ar).max().getAsInt();
        int min = Arrays.stream(ar).min().getAsInt();

        int range = max - min + 1;
        int count[] = new int[range];
        int output[] = new int[ar.length];

        for (int i = 0; i < ar.length; i++) {
            count[ar[i] - min]++;
        }

        //Arrays.stream(count).forEach(e-> System.out.print(e+" "));
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = ar.length - 1; i >= 0; i--) {
            output[count[ar[i] - min] - 1] = ar[i];
            count[ar[i] - min]--;
        }

        for (int i = 0; i < ar.length; i++) {
            ar[i] = output[i];
        }

        Arrays.stream(ar).forEach(e-> System.out.print(e+" "));
    }
    public static void main(String args[]) {

        int[] ar = { -5, -10, 0, -3, 8, 5, -1, 10 };
        countSortHandleNegativeNumbers(ar);
    }
}
