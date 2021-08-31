package com.codingchamps.Arrays;

import java.util.Arrays;

/*Segregate even and odd numbers | Set 3
        Difficulty Level : Easy
        Last Updated : 23 Jul, 2021
        Given an array of integers, segregate even and odd numbers in the array.
        All the even numbers should be present first, and then the odd numbers.

        Examples:

        Input: arr[] = 1 9 5 3 2 6 7 11
        Output: 2 6 5 3 1 9 7 11

        Input: arr[] = 1 3 2 4 7 6 9 10
        Output:  2 4 6 10 7 1 9 3*/
public class ArrayProb7 {

    // The optimization for above approach is based on Lomuto’s Partition Scheme
    // Time Complexity : O(n)
    // Auxiliary Space : O(1)
    public static void main(String args[]){
        int ar[] = {1, 3, 2, 4, 7, 6, 9, 10};
        int lastIndex=0;
        for(int i=0;i<ar.length;i++){
            if(ar[i]%2==0){
                int temp = ar[lastIndex];
                ar[lastIndex] = ar[i];
                ar[i] = temp;
                lastIndex++;
            }
        }
        Arrays.stream(ar).forEach(e -> System.out.print(e+" "));
    }
}
