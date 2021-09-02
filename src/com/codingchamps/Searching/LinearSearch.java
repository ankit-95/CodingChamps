package com.codingchamps.Searching;

public class LinearSearch {

    public static void main(String args[]) {
        int ar[] = {4, 3, 1, 2, 45, 6};
        int find = -1;
        int i=0;
        for (i = 0; i < ar.length; i++) {
            if(ar[i] == find){
                break;
            }
        }
        if(i < ar.length){
            System.out.println("Element Found at index "+(i)+" : "+ ar[i]);
        } else
            System.out.println("Element not found");
    }
}
