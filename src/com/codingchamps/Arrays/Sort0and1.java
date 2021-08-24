package com.codingchamps.Arrays;

import java.util.Arrays;

public class Sort0and1 {
    public static void main(String args[]){

        int ar[] = {1,0,1,0,1,0,1,1,0,0,1,0,1};
        int size = ar.length;
        int count_0=0;
        for(int i=0;i<size;i++){
            if(ar[i] == 0){
                int temp = ar[count_0];
                ar[count_0] = ar[i];
                ar[i] = temp;
                count_0++;
            }
        }

        Arrays.stream(ar).forEach(System.out :: print);
    }
}
