package com.codingchamps.Sorting;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

public class NearlySortedAlgorithm {

    public static void kSort(int ar[],int n,int k){

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i=0;i<k+1;i++){
            queue.add(ar[i]);
        }

        int index=0;
        for(int i=k+1;i<n;i++){
            ar[index++] = queue.peek();
            queue.poll();
            queue.add(ar[i]);
        }

        Iterator<Integer> itr = queue.iterator();

        while (itr.hasNext()) {
            ar[index++] = queue.peek();
            queue.poll();
        }
    }

    public static void main(String[] args)
    {
        int k = 3;
        int arr[] = { 2, 6, 3, 12, 56, 8 };
        int n = arr.length;
        kSort(arr, n, k);
        System.out.println("Following is sorted array : ");
        Arrays.stream(arr).forEach(e-> System.out.print(e+" "));
    }


}
