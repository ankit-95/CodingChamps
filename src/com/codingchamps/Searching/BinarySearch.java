package com.codingchamps.Searching;

import java.util.Arrays;

// Pre requisite of Binary Search is sorted in ascending order
public class BinarySearch {

    public static boolean binarySeach(int ar[], int p, int r, int find){
        if(p<=r){
            int mid =  p + r -1 /2;
            if(ar[mid] == find){
                return true;
            } else if(find > ar[mid]){
                return binarySeach(ar,mid+1,r,find);
            } else {
                return binarySeach(ar,p,mid-1,find);
            }
        }
        return false;
    }
    public static void main(String args[]){
        int ar[] = {4, 3, 1, 2, 45, 6};
        int find = -1;

        Arrays.sort(ar);
        System.out.println(binarySeach(ar,0,ar.length-1,find));
    }
}
