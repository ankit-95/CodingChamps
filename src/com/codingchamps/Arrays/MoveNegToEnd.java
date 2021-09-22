package com.codingchamps.Arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

// Move all negative no. to end while maintaining there order in array.
public class MoveNegToEnd {

    public static void main(String args[]){

        int n = 8;
        int ar[] = {-1, -9, 3, 2, -7, -5, 11, 6 };

        int copy[] = new int[ar.length];
        int index=0;
        for(int i=0;i<ar.length;i++){
            if(ar[i]>=0){
                copy[index++] = ar[i];
            }
        }
        for(int i=0;i<ar.length;i++){
            if(ar[i]<0){
                copy[index++] = ar[i];
            }
        }


        System.out.println("New: ");
        Arrays.stream(ar).forEach(e-> System.out.print(e+" "));
        System.out.println("\nCopy: ");
        Arrays.stream(copy).forEach(e-> System.out.print(e+" "));
    }
}
