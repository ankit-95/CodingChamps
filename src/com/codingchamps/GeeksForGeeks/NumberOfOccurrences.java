package com.codingchamps.GeeksForGeeks;

public class NumberOfOccurrences {

    public static int binarySearch(int ar[],int p, int r, int x){
        if(p<r){
            int mid =  (p + r -1) /2;
            if(ar[mid] == x){
                return mid;
            }
            else if(ar[mid] < x){
                return binarySearch(ar,mid+1,r ,x);
            }
            else if(ar[mid]>x){
                return binarySearch(ar,p,mid-1,x);
            }
        }
        return -1;
    }
    // T.C : O(logn + count)
    public static int count(int[] arr, int n, int x) {

        int mid = binarySearch(arr,0,arr.length-1,x);
        if(mid==-1){
            return -1;
        }
        int count=1;
        int left = mid-1;
        while(left>=0 && arr[left]==x) {
            count++;
            left--;
        }
        int right = mid+1;
        while(right<arr.length && arr[right]==x) {
            count++;
            right++;
        }
        return count;
    }


    public static int firstIndex(int ar[],int p, int r, int x){
        if(p<=r){
            int mid =  (p + r) /2;
            if(ar[mid] == x && (mid==0 || ar[mid-1] < x))
                return mid;
            else if(ar[mid] < x)
                return firstIndex(ar,mid+1,r ,x);
            else
                return firstIndex(ar,p,mid-1,x);
        }
        return -1;
    }

    public static int lastIndex(int ar[],int p, int r, int x){
        if(p<=r){
            int mid =  (p + r) /2;
            if(ar[mid] == x && (mid==ar.length-1 || ar[mid+1] > x))
                return mid;
            else if(ar[mid]>x)
                return lastIndex(ar,p,mid-1,x);
            else
                return lastIndex(ar,mid+1,r ,x);
        }
        return -1;
    }

    public static int countBS(int arr[], int n , int x){
        // index of first occurrence of x in arr[0..n-1]
        int i;

        // index of last occurrence of x in arr[0..n-1]
        int j;

        /* get the index of first occurrence of x */
        i = firstIndex(arr, 0, arr.length-1, x);
        /* If x doesn't exist in arr[] then return -1 */
        if(i == -1)
            return i;

      /* Else get the index of last occurrence of x.
         Note that we are only looking in the
         subarray after first occurrence */
        j = lastIndex(arr, i, arr.length-1, x);
        /* return count */
        return j-i+1;
    }
    public static void main(String args[]){
        int ar[] = {1, 1, 2, 2, 2,2,3};
        System.out.println(count(ar,ar.length,2));
        System.out.println(countBS(ar,ar.length,2));
    }
}
