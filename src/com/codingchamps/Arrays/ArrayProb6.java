package com.codingchamps.Arrays;

import java.util.Arrays;

/*Rearrange an array in order – smallest, largest, 2nd smallest, 2nd largest, ..
        Difficulty Level : Easy
        Last Updated : 21 Apr, 2021
        Given an array of integers, task is to print the array in the order – smallest number, Largest number, 2nd smallest number, 2nd largest number, 3rd smallest number, 3rd largest number and so on…..
        Examples:


        Input : arr[] = [5, 8, 1, 4, 2, 9, 3, 7, 6]
        Output :arr[] = {1, 9, 2, 8, 3, 7, 4, 6, 5}

        Input : arr[] = [1, 2, 3, 4]
        Output :arr[] = {1, 4, 2, 3}
        Time Complexity : O(n Log n)
        Auxiliary Space : O(n)
        */

public class ArrayProb6 {

    public static void moveNegativeNumber(){
        int ar[] = {-3,7,-2,-1,6,17,-10};
        int index=-1;
        for(int i=0;i<ar.length;i++){
            if(ar[i]<0){
                index++;
                int temp = ar[index];
                ar[index] = ar[i];
                ar[i] = temp;
            }
        }

        Arrays.stream(ar).forEach(e -> System.out.print(e+" "));
    }
    public static void main(String args[]){
        int ar[] = {5, 8, 1, 4, 2, 9, 3, 7, 6};
        int b[] = new int[ar.length];
        for(int i=0;i<ar.length;i++){
            b[i] = ar[i];
        }
        Arrays.sort(b);
        int max = ar.length-1;
        int min =0;
        for(int i=0;i<ar.length;i++){
            if(i%2!=0){
                ar[i] = b[max];
                max--;
            } else {
                ar[i] = b[min];
                min++;
            }
        }
        Arrays.stream(ar).forEach(e -> System.out.print(e+" "));

        moveNegativeNumber();
    }
}
