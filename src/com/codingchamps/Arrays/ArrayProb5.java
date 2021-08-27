package com.codingchamps.Arrays;

import java.util.Arrays;

public class ArrayProb5 {

    public static void modifyArray(int ar[]) {
        for (int i = 0; i < ar.length-1; i++) {
            if (ar[i] != 0 && ar[i + 1] != 0 && ar[i]==ar[i+1]) {
                ar[i] = ar[i] * 2;
                ar[i+1] = 0;
            }
        }
        int index = 0;
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] != 0) {
                ar[index++]  = ar[i];
            }
        }
        while(index < ar.length){
            ar[index++] = 0;
        }
    }
    public static void main(String args[]){
        int ar[] = {0,0, 0, 0, 0, 9, 0, 31, 31, 0, 0, 12, 46, 0, 4};
        modifyArray(ar);
        Arrays.stream(ar).forEach(e-> System.out.print(e+" "));
    }
}
