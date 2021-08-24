package com.codingchamps.Arrays;

import java.util.Arrays;
import java.util.Collections;

public class SortZeroToEnd {

    public static void main(String args[]){

        int ar[] = {1, 2, 0, 4, 3, 0, 5, 0};
        int size = ar.length;
        int index = ar.length-1;

        // Brute force Approach with O(n * n) Complexity
        for(int i=0;i<ar.length;i++){
            for(int j=i+1;j<ar.length;j++){
                if(ar[i] == 0 ){
                    int temp = ar[i];
                    ar[i] = ar[j];
                    ar[j] = temp;
                }
            }
        }

        Arrays.stream(ar).forEach(System.out :: print);

    }
}
