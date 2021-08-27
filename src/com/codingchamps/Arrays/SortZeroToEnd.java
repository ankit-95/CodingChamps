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

        System.out.println();
        int ar1[] = {1, 2, 0, 4, 3, 0, 5, 0};
        int size1 = ar1.length;
        int index1 = ar1.length-1;
        int index_0=0;
        // O(n) - Need to think of this logic
        for(int i=0;i<size1;i++){
            if(ar1[i]!=0){
                ar1[index_0++] =ar1[i];
            }
        }
        while (index_0 < size1){
            ar1[index_0++] = 0;
        }

        Arrays.stream(ar1).forEach(System.out :: print);
    }
}
