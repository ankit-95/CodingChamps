package com.codingchamps.Sorting;

public class SelectionSort {
    public static void main(String args[]) {
        int ar[] = {4,6,2,1,3,5};

        for(int i=0;i<ar.length;i++){
           int min =i;
           for(int j=i+1;j<ar.length;j++){
               if(ar[min] > ar[j])
                   min = j;
           }
           int temp = ar[i];
           ar[i] = ar[min];
           ar[min] = temp;
        }
        for(int x : ar){
            System.out.print(x+" ");
        }
    }
}
