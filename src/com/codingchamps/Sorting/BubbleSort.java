package com.codingchamps.Sorting;

public class BubbleSort {

    public static void main(String args[]) {
        int ar[] = {4, 6, 2, 1, 3, 5};

        for(int i=0;i<ar.length;i++){
            for(int j=0;j<ar.length;j++){
                if(ar[j] > ar[i]){
                    int temp = ar[j];
                    ar[j] = ar[i];
                    ar[i] = temp;
                }
            }
        }

        for (int x : ar){
            System.out.print(x + " ");
        }
    }
}
