package com.codingchamps.GeeksForGeeks;

//Given a sorted array of n distinct integers where each integer is in the range from 0 to m-1 and m > n.
//Find the smallest number that is missing from the array.
//
//        Input: {0, 1, 2, 6, 9}, n = 5, m = 10
//        Output: 3
//
//        Input: {4, 5, 10, 11}, n = 4, m = 12
//        Output: 0
//
//        Input: {0, 1, 2, 3}, n = 4, m = 5
//        Output: 4
//
//        Input: {0, 1, 2, 3, 4, 5, 6, 7, 10}, n = 9, m = 11
//        Output: 8

public class FindSmallestMissingNumber {

    //Time Complexity: O(m*n)
    public static int app1(int ar[], int m) {
        int i = 0;
        for (i = 0; i < m; i++) {
            boolean flag = false;
            for (int j = 0; j < ar.length; j++) {
                if (ar[j] == i) {
                    flag = true;
                    break;
                }
            }
            if (flag == true)
                continue;
            else
                break;
        }
        return i;
    }

    //Time Complexity: O(n)
    public static int app2(int ar[], int m) {
        int i = 0;
        for (i = 0; i < ar.length - 1; i++) {
            if (Math.abs(ar[i] - ar[i + 1]) > 1) {
                break;
            }
        }
        return ar[i] + 1;
    }

    //Time Complexity: O(logn)
    public static int app3(int ar[], int start, int end) {
        if (start > end) {
            return end + 1;
        }
        if (start != ar[start]) {
            return start;
        }
        int mid = (start + end) / 2;
        if (mid == ar[mid])
            return app3(ar, mid + 1, end);
        return app3(ar, start, mid);
    }


    public static boolean binarySeach(int ar[], int p, int r, int find) {
        if (p <= r) {
            int mid = p + r - 1 / 2;
            if (ar[mid] == find) {
                return true;
            } else if (find > ar[mid]) {
                return binarySeach(ar, mid + 1, r, find);
            } else {
                return binarySeach(ar, p, mid - 1, find);
            }
        }
        return false;
    }

    //Time Complexity: O(mlogn)
    public static int app4(int ar[], int m) {
        //  Arrays.sort(ar);

        int i = 0;
        for (i = 0; i < m; i++) {
            boolean flag = binarySeach(ar, 0, ar.length - 1, i);
            if (flag == false)
                break;
        }
        return i;
    }


    // Program to find Smallest
    // Missing in Sorted Array
    public static int findSmallestMissinginSortedArray(
            int[] arr) {
        // Check if 0 is missing
        // in the array
        if (arr[0] != 0)
            return 0;

        // Check is all numbers 0 to n - 1
        // are present in array
        if (arr[arr.length - 1] == arr.length - 1)
            return arr.length;

        int first = arr[0];

        return findFirstMissing(arr, 0,
                arr.length - 1, first);
    }

    // Program to find missing element
    public static int findFirstMissing(int[] arr, int start,
                                       int end, int first) {

        if (start < end) {
            int mid = (start + end) / 2;

            /** Index matches with value
             at that index, means missing
             element cannot be upto that point */
            if (arr[mid] != mid + first)
                return findFirstMissing(arr, start,
                        mid, first);
            else
                return findFirstMissing(arr, mid + 1,
                        end, first);
        }
        return start + first;

    }

    public static void main(String args[]) {

        int ar[] = {0, 1, 2, 3, 4, 5, 6, 7, 10};

        int m = 11;

        System.out.print(findSmallestMissinginSortedArray(ar));
    }
}
