package com.codingchamps.GeeksForGeeks;

//Using Heap Data structure
import java.util.Arrays;

public class KthLargestElement {

    public static void buildHeap(int ar[], int n){

        for(int i=(n-1)/2;i>=0;i--){
            heapify(ar,n,i);
        }
    }

    public static void heapify(int ar[],int n,int i){

        int largest = i;
        int l = (2*i) +1;
        int r = (2*i) +2;

        if(l<n && ar[l] > ar[largest])
            largest = l;
        if(r<n && ar[r] > ar[largest])
            largest = r;
        if(largest!=i){
            int temp = ar[largest];
            ar[largest] = ar[i];
            ar[i] = temp;
            heapify(ar,n,largest);
        }
    }

    public static void findkthLargest(int ar[],int k){
        buildHeap(ar,k);
        for(int i=k;i<ar.length;i++){
            if(ar[i] < ar[0]){
                ar[0] = ar[i];
                heapify(ar,ar.length,0);
            }
        }
        Arrays.stream(ar).forEach(e-> System.out.print(e+" "));
        System.out.println("\nKth Largest Element : " + ar[0]);
    }
    public static void main(String args[]){

        int ar[] = { 12, 3, 5, 7, 19 };
        int k = 2;

        findkthLargest(ar,k);

    }
}
