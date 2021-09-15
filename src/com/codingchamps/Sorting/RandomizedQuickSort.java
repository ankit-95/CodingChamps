package com.codingchamps.Sorting;

import java.util.Random;

public class RandomizedQuickSort {

    private static void swap(int ar[], int p, int r){
        int temp = ar[p];
        ar[p] = ar[r];
        ar[r] = temp;
    }

    static void random(int arr[],int low,int high)
    {
        Random rand= new Random();
        int pivot = rand.nextInt(high-low)+low;

        int temp1=arr[pivot];
        arr[pivot]=arr[low];
        arr[low]=temp1;
    }

    private static int randomizedPartition(int[] ar, int p, int r) {
        random(ar,p,r);
        int pivot = ar[p];
        int i = p +1;
        for(int j= p+1;j<=r;j++){
            if(ar[j] < pivot){
                swap(ar,i,j);
                i++;
            }
        }
        ar[p] = ar[i-1];
        ar[i-1] = pivot;
        return i-1;
    }

    private static void randomizedQuickSort(int[] ar, int p, int r) {
        if(p<r){
            int pivot = randomizedPartition(ar,p,r);
            randomizedQuickSort(ar,p,pivot-1);
            randomizedQuickSort(ar,pivot+1,r);
        }
    }

    public static void main(String args[]) {

        System.out.print("\nRandomized Quick Sort : ");
        int ar1[] = {4, 6, 2, 1, 3, 5};
        randomizedQuickSort(ar1,0,ar1.length-1);
        for(int x : ar1){
            System.out.print(x + " ");
        }
    }
}
