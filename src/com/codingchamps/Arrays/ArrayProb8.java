package com.codingchamps.Arrays;

/* Find the smallest missing number
        Difficulty Level : Medium
        Last Updated : 16 Jun, 2021
        Given a sorted array of n distinct integers where each integer is in the range from 0 to m-1 and m > n. Find the smallest number that is missing from the array.

        Examples:
        Input: {0, 1, 2, 6, 9}, n = 5, m = 10
        Output: 3

        Input: {4, 5, 10, 11}, n = 4, m = 12
        Output: 0

        Input: {0, 1, 2, 3}, n = 4, m = 5
        Output: 4

        Input: {0, 1, 2, 3, 4, 5, 6, 7, 10}, n = 9, m = 11
        Output: 8
*/

public class ArrayProb8 {
    public static void main(String args[]){
	// Linear Search , T.C : O(n)
        int ar[] = {0, 1, 2, 3, 4, 5, 6, 7, 10};
        int m =11;
        m = m-1;
        int minValue = 0;
        if(ar[0]!=0){
            System.out.println(0);
            System.exit(0);
        } else {
            for(int i=1;i<ar.length;i++){
                if(ar[i-1]+1 == ar[i]){
                    continue;
                } else {
                    if(ar[i] > ar[i-1] + 1){
                        System.out.println(ar[i-1] + 1);
                        System.exit(0);
                    }
                }
            }
        }
        System.out.println(m);
    }
}
