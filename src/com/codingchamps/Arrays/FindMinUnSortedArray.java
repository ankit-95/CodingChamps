package com.codingchamps.Arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class FindMinUnSortedArray {

    int[] printUnsorted(int[] ar, int n) {

        if (n <= 1) {
            int result[] = new int[2];
            result[0] = 0;
            result[1] = 0;
            return result;
        }
        int s = 0;
        int e = n - 1;

        for (s = 0; s < n - 1; s++) {
            if (ar[s] > ar[s + 1]) {
                break;
            }
        }

        if (s == n - 1) {
            return ar;
        }

        for (e = n - 1; e > 0; e--) {
            if (ar[e - 1] > ar[e]) {
                break;
            }
        }
        int min = ar[s], max = ar[s];
        for (int i = s + 1; i <= e; i++) {
            if (ar[i] > max) {
                max = ar[i];
            }
            if (ar[i] < min) {
                min = ar[i];
            }
        }

        for (int i = 0; i < s; i++) {
            if (ar[i] > min) {
                s = i;
                break;
            }
        }

        for (int i = n - 1; i >= e + 1; i--) {
            if (ar[i] < max) {
                e = i;
                break;
            }
        }

        int result[] = new int[2];
        result[0] = s;
        result[1] = e;

        return result;
    }

    public static void main(String args[]){
        int ar[] = {0, 1, 15, 25, 6, 7, 30, 40, 50};

        FindMinUnSortedArray findArr = new FindMinUnSortedArray();

        int result [] = findArr.printUnsorted(ar,ar.length);

        Arrays.stream(result).forEach(e -> System.out.print(e+" "));

    }
}
