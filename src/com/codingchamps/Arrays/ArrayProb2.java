package com.codingchamps.Arrays;

/*Rearrange array such that arr[i] >= arr[j] if i is even and arr[i]<=arr[j] if i is odd and j < i
Difficulty Level : Medium
        Last Updated : 22 Jul, 2021
        Given an array of n elements.
        Our task is to write a program to rearrange the array such that elements at even positions are greater
        than all elements before it and elements at odd positions are less than all elements before it.
        Examples:


        Input : arr[] = {1, 2, 3, 4, 5, 6, 7}
        Output : 4 5 3 6 2 7 1

        Input : arr[] = {1, 2, 1, 4, 5, 6, 8, 8}
        Output : 4 5 2 6 1 8 1 8*/

import java.util.Arrays;

public class ArrayProb2 {

    /*Time Complexity: O( n logn )
    Auxiliary Space: O(n)*/
    public static void naiveApproach(){
        int ar[] = {1, 2, 1, 4, 5, 6, 8, 8};
        int arnew [] = new int[ar.length];
        for(int i=0;i<ar.length;i++){
            arnew[i] = ar[i];
        }
        Arrays.sort(arnew);
        int size = ar.length-1;
        int indexEven = size%2==0? size-1: size;
        int ele = ar.length-1;
        for(int i=indexEven; i>=0;i=i-2){
            ar[i] = arnew[ele];
            ele--;
        }
        for(int i=0; i<ar.length;i=i+2){
            ar[i] = arnew[ele];
            ele--;
        }
        Arrays.stream(ar).forEach(e -> System.out.print(e+" "));
    }
    public static void main(String args[]){

        naiveApproach();
    }
}
