package com.codingchamps.GeeksForGeeks;

//Using Heap Data structure
import java.util.Arrays;

/*Kth smallest element
        Medium Accuracy: 46.66% Submissions: 100k+ Points: 4
        Given an array arr[] and an integer K where K is smaller than size of array,
        the task is to find the Kth smallest element in the given array. It is given that all array elements are distinct.

        Example 1:
        Input:
        N = 6
        arr[] = 7 10 4 3 20 15
        K = 3
        Output : 7
        Explanation :
        3rd smallest element in the given
        array is 7.

        Example 2:
        Input:
        N = 5
        arr[] = 7 10 4 20 15
        K = 4
        Output : 15
        Explanation :
        4th smallest element in the given
        array is 15.
        */
public class KthSmallestElement {

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

    public static void findkthSmallest(int ar[],int k){
        buildHeap(ar,k);
        for(int i=k;i<ar.length;i++){
            if(ar[i] < ar[0]){
                ar[0] = ar[i];
                heapify(ar,k,0);
            }
        }
        Arrays.stream(ar).forEach(e-> System.out.print(e+" "));
        System.out.println("\nKth Largest Element : " + ar[0]);
    }
    public static void main(String args[]){

        int ar[] = { 12, 3, 5, 7, 19 };
        int k = 3;

        findkthSmallest(ar,k);

    }
}
