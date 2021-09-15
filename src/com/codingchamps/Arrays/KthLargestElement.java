package com.codingchamps.Arrays;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;

public class KthLargestElement {

    /*
    Method 1 (Use Bubble k times)
    1) Modify Bubble Sort to run the outer loop at most k times.
    2) Print the last k elements of the array obtained in step 1.
    Time Complexity: O(n*k)
    */
    public static void modifiedBubbleSort(int ar[], int k){
        for(int i=0;i < k + 1;i++){
            for(int j = i+1; j < ar.length;j++){
                if(ar[i] > ar[j]){
                    int temp = ar[i];
                    ar[i] = ar[j];
                    ar[j] = temp;
                }
            }
        }
        System.out.println(ar[ar.length-1]+" "+ar[ar.length-2]+" "+ar[ar.length-3]);
    }

    public static void modifiedSelectionSort(int ar[], int k){
        for(int i=0;i < k + 1;i++){
            int max = i;
            for(int j = i+1; j < ar.length;j++){
                if(ar[max] < ar[j]){
                    max = j;
                }
            }
            int temp = ar[max];
            ar[max] = ar[i];
            ar[i] = temp;
        }
        System.out.println(ar[0]+" "+ar[1]+" "+ar[2]);
    }
    public static void main(String args[]){

        int ar[] = {1, 23, 12, 9, 30, 2, 50};
        int k=3;
      //  modifiedBubbleSort(ar,k);
        modifiedSelectionSort(ar,k);
    }
}
