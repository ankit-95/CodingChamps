package com.codingchamps.GeeksForGeeks;

public class CountZeroes {

    static int binarySearch(int ar[],int p,int r){
        if(p <r){
            int mid = (p+r)/2;
            if(ar[mid]==0 && mid >0 && ar[mid-1]!=0){
                return mid;
            } else if(ar[mid] > 0){
                return binarySearch(ar,mid+1,r);
            } else {
                return binarySearch(ar,p,mid);
            }
        }
        return -1;
    }
    static int countZeroes(int[] arr, int n) {
        if(arr[0] != 0){
            int index = binarySearch(arr,0,n);
            if(index >0){
                return n - index;
            } else
                return 0;
        } else
            return n;
    }

    public static void main(String args[]){
        int ar1[] = {0, 0, 0, 0, 0};
        int ar2[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0};

        System.out.println("No. of Zeroes : "+ countZeroes(ar1,ar1.length));
        System.out.println("No. of Zeroes : "+ countZeroes(ar2,ar2.length));

    }
}
