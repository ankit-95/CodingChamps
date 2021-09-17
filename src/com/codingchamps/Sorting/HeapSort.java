package com.codingchamps.Sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

public class HeapSort {

    public static void heapSort(int ar[]){

        //Build Heap
        for(int i= ar.length/2 -1;i>=0;i--){
            heapify(ar,ar.length,i);
        }

        for(int i= ar.length -1;i>0;i--){

            // Move current root to end
            int temp = ar[0];
            ar[0] = ar[i];
            ar[i] = temp;

            // call max heapify on the reduced heap
            heapify(ar, i, 0);
        }
    }

    public static void heapify(int ar[], int n, int i){
        int largest = i; // Initialize largest root node
        int l = 2 * i + 1; // left child
        int r = 2 * i + 2; // right child

        // if left node is largest
        if(l<n && ar[l] > ar[largest])
            largest = l;
        // if right node is largest
        if(r<n && ar[r] > ar[largest])
            largest = r;

        if(largest!=i) {
            int temp = ar[i];
            ar[i] = ar[largest];
            ar[largest] = temp;

            // Recursively heapify the affected sub-tree
            heapify(ar,n,largest);
        }
    }

    public static void main(String args[]){

        int ar[] = {10,3,6,1,8,4,7};

        heapSort(ar);

        Arrays.stream(ar).forEach(e -> System.out.print(e+" "));
    }
}
