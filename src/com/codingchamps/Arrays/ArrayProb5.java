package com.codingchamps.Arrays;

import java.util.Arrays;

/*
Double the first element and move zero to end
        Difficulty Level : Easy
        Last Updated : 24 May, 2021
        For a given array of n integers and assume that ‘0’ is an invalid number and all others as a valid number. Convert the array in such a way that if both current and next element is valid then double current value and replace the next number with 0. After the modification, rearrange the array such that all 0’s shifted to the end.
        Examples:

        Input : arr[] = {2, 2, 0, 4, 0, 8}
        Output : 4 4 8 0 0 0

        Input : arr[] = {0, 2, 2, 2, 0, 6, 6, 0, 0, 8}
        Output :  4 2 12 8 0 0 0 0 0 0

        Time Complexity: O(n).
*/

public class ArrayProb5 {

    public static void modifyArray(int ar[]) {
        for (int i = 0; i < ar.length-1; i++) {
            if (ar[i] != 0 && ar[i + 1] != 0 && ar[i]==ar[i+1]) {
                ar[i] = ar[i] * 2;
                ar[i+1] = 0;
            }
        }
       /* int index = 0;
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] != 0) {
                ar[index++]  = ar[i];
            }
        }
        while(index < ar.length){
            ar[index++] = 0;
        }*/
        int lastSeenPositiveIndex = 0;
        for( int index = 0; index < ar.length; index++)
        {
            if(ar[index] != 0)
            {
                swap(ar,index, lastSeenPositiveIndex);
                lastSeenPositiveIndex++;
            }
        }
    }
    public static void swap(int[] A, int i, int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    public static void main(String args[]){
        int ar[] = {0,0, 0, 0, 0, 9, 0, 31, 31, 0, 0, 12, 46, 0, 4};
        modifyArray(ar);
        Arrays.stream(ar).forEach(e-> System.out.print(e+" "));
    }
}
