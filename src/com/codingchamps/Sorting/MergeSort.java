package com.codingchamps.Sorting;

public class MergeSort {

    public static void mergeSort(int ar[], int p,int r){
        if(p<r){
            int mid = (p+(r-1))/2;
            mergeSort(ar,p,mid);
            mergeSort(ar,mid+1,r);
            merge(ar,p,mid,r);
        }
    }

    public static void merge(int ar[],int p,int mid,int r){

        int n1 = mid-p+1;
        int n2 = r - mid;
        int l1[] = new int[n1];
        int l2[] = new int[n2];
        for(int i=0;i<n1;i++){
            l1[i] = ar[i + p];
        }
        for(int j=0;j<n2;j++){
            l2[j] = ar[mid + 1 + j];
        }
        int i=0, j=0;
        int k=p;
        while(i<n1 && j < n2){
            if(l1[i] <= l2[j]){
                ar[k] = l1[i];
                i++; k++;
            } else {
                ar[k] = l2[j];
                j++; k++;
            }
        }
        while(i<n1){
            ar[k] = l1[i];
            i++; k++;
        }
        while(j < n2){
            ar[k] = l2[j];
            j++; k++;
        }
    }
    public static void main(String args[]) {
        int ar[] = {4, 6, 2, 1, 3, 5};
        mergeSort(ar,0,ar.length-1);
        for(int x : ar){
            System.out.print(x + " ");
        }
    }
}
