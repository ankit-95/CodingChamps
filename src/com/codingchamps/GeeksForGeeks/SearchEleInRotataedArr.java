package com.codingchamps.GeeksForGeeks;

public class SearchEleInRotataedArr {

    public static int findElement(int ar[], int n,int key){
        int pivot = findPivot(ar,0,n-1);
        if(pivot==-1){
           return binarySearch(ar,0,n-1,key);
        }
        if(ar[pivot]==key){
            return pivot;
        }
        if(ar[0] <= key){
            return binarySearch(ar,0,pivot-1,key);
        }
        return binarySearch(ar,pivot+1,n-1,key);
    }
    public static int findPivot(int ar[], int low,int high){
        if(high < low){
            return -1;
        }
        if (high == low)
            return low;
        int mid = (low + high)/2;
        if(mid > low && ar[mid]< ar[mid-1]){
            return mid-1;
        }
        if(mid < high && ar[mid]> ar[mid+1]){
            return mid;
        }
        if(ar[low]>=ar[mid]){
            return findPivot(ar,low,mid-1);
        }
            return findPivot(ar,mid+1,high);
    }
    public static int binarySearch(int ar[], int low,int high, int key){
        if(high < low){
            return -1;
        }
        int mid = (low + high)/2;
        if(ar[mid] == key){
            return mid;
        }
        if(ar[mid]<key){
            return binarySearch(ar,mid+1,high,key);
        }
        return binarySearch(ar,low,mid-1,key);
    }
    public static void main(String args[]){
        int ar1[] = {3,4,5,1,2};
        int key1 = 1;

        int ar2[] = {1,2,3,4,5};
        int key2 = 3;
        System.out.println("Element Found at Index in ar[]: "+ findElement(ar1,5,key1));

        System.out.println("Element Found at Index in ar2[]: "+ findElement(ar2,5,key2));
    }
}
