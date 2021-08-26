package com.codingchamps.Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
Rearrange an array such that arr[i] = i
Difficulty Level : Easy
        Given an array of elements of length N, ranging from 0 to N – 1. All elements may not be present in the array.
        If the element is not present then there will be -1 present in the array.
        Rearrange the array such that A[i] = i and if i is not present, display -1 at that place.

        Examples:
        Input : arr = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1}
        Output : [-1, 1, 2, 3, 4, -1, 6, -1, -1, 9]

        Input : arr = {19, 7, 0, 3, 18, 15, 12, 6, 1, 8,
        11, 10, 9, 5, 13, 16, 2, 14, 17, 4}
        Output : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
        11, 12, 13, 14, 15, 16, 17, 18, 19]
*/
public class ArrayProb1 {

    // Time Complexity : O(n^2)
    public static void naiveApproach(){
        int ar[]= {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};
        boolean flag=false;
        for(int i=0;i<ar.length;i++){
            for(int j=0;j<ar.length;j++){
                if(ar[j]==i){
                    int temp = ar[i];
                    ar[i] = ar[j];
                    ar[j] = temp;
                    break;
                }
            }
        }
        for(int i = 0; i < ar.length; i++) {
            // If not present
            if (ar[i] != i) {
                ar[i] = -1;
            }
        }
        Arrays.stream(ar).forEach( e -> System.out.print(e+" "));
    }

    // Time Complexity : O(n) using HashSet, Aux Space Complexity: O(n)
    public static void usingHashSet(){
        int ar[]= {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};
        Set<Integer> hashSet = new HashSet<>();
        for(int i=0;i<ar.length;i++){
            if(!hashSet.contains(ar[i])){
                hashSet.add(ar[i]);
            }
        }
        for(int i=0;i<ar.length;i++){
            if(hashSet.contains(i)){
                ar[i] = i;
            } else
                ar[i]=-1;
        }
        Arrays.stream(ar).forEach( e -> System.out.print(e+" "));
    }

    public static void anotherApproach(){
        int ar[]= {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};
        for(int i=0;i<ar.length;){
            if(ar[i]>=0 && ar[i]!=i){
                int ele = ar[ar[i]];
                ar[ar[i]] = ar[i];
                ar[i] = ele;
            } else {
                i++;
            }
        }
        Arrays.stream(ar).forEach( e -> System.out.print(e+" "));
    }
    public static void main(String args[]){

        naiveApproach();
        System.out.println();
        usingHashSet();
        System.out.println();
        anotherApproach();
    }
}