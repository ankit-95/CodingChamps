package com.codingchamps.Arrays;

/*
Find the smallest and second smallest element in an array
        Basic Accuracy: 39.54% Submissions: 5490 Points: 1
        Given an array of integers, your task is to find the smallest and second smallest element in the array.
        If smallest and second smallest do not exist, print -1.
*/
public class SecondMinimumElement {

    public static long[] minAnd2ndMin(long ar[], long n) {
        long min1, min2;
        min1 = min2 = Long.MAX_VALUE;
        ;
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] < min1) {
                min2 = min1;
                min1 = ar[i];
            }
            if (ar[i] != min1 && ar[i] < min2) {
                min2 = ar[i];
            }
        }
        long result[] = new long[2];
        if (min2 != Long.MAX_VALUE) {
            result[0] = min1;
            result[1] = min2;
        } else {
            result[0] = -1;
            result[1] = -1;
        }
        return result;
    }

    public static void main(String args[]) {

       // long ar[] = {2, 4, 3, 5, 6};
          long ar[] = {1, 1, 1, 1};

        long result[] = minAnd2ndMin(ar, ar.length);

        for (long x : result) {
            System.out.print(x + " ");
        }

    }
}
