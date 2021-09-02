package com.codingchamps.Sorting;

public class InsertionSort {
    public static void main(String args[]) {
        int ar[] = {4,6,2,1,3,5};

        for(int i=1;i<ar.length;i++){
            int key = ar[i];
            int j= i-1;
            while(j>=0 && key < ar[j]){
                ar[j+1] = ar[j];
                j=j-1;
            }
            ar[j+1] = key;
        }
        for(int x : ar){
            System.out.print(x+" ");
        }
    }
}
