package com.codingchamps.Arrays;

import java.util.Arrays;

/* Rearrange positive and negative numbers in O(n) time and O(1) extra space
   Difficulty Level : Medium
   Last Updated : 29 Apr, 2021
   An array contains both positive and negative numbers in random order.
   Rearrange the array elements so that positive and negative numbers are placed alternatively.
   Number of positive and negative numbers need not be equal.
   If there are more positive numbers they appear at the end of the array. If there are more negative numbers,
   they too appear in the end of the array.
   For example, if the input array is [-1, 2, -3, 4, 5, 6, -7, 8, 9],
   then the output should be [9, -7, 8, -3, 5, -1, 2, 4, 6]
   *
   Time Complexity: O(n) where n is number of elements in given array.
   Auxiliary Space: O(1)
  */
public class ArrayProb3 {

    public static  void rearrangeArray(int ar[]){

        // Partition Algo, so that all -ve no.'s are infront.
        int index = -1;
        for(int i=0;i<ar.length;i++){
            if(ar[i]<0){
                index++;
                int temp = ar[i];
                ar[i] = ar[index];
                ar[index] = temp;
            }
        }

        int pos = index +1, neg=0;
        while(pos<ar.length && neg < pos && ar[neg]<0){
            int temp = ar[pos];
            ar[pos] = ar[neg];
            ar[neg] = temp;
            pos++;
            neg=neg+2;
        }
    }
    public static void main(String args[]){
        int ar[] = {-1,2,-3,4,5,6,-7,8,9};

        rearrangeArray(ar);

        Arrays.stream(ar).forEach(e-> System.out.print(e+" "));
    }
}
