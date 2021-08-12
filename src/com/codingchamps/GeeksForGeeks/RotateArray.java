package com.codingchamps.GeeksForGeeks;

/*
Possibly your code doesn't work correctly for multiple test-cases (TCs).

        The first test case where your code failed:

        Input:

        77 69
        40 13 27 87 95 40 96 71 35 79 68 2 98 3 18 93 53 57 2 81 87 42 66 90 45 20 41 30 32 18 98 72 82 76 10 28 68 57 98 54 87 66 7 84 20 25 29 72 33 30 4 20 71 69 9 16 41 50 97 24 19 46 47 52 22 56 80 89 65 29 42 51 94 1 35 65 25

        Its Correct output is:

        29 42 51 94 1 35 65 25 40 13 27 87 95 40 96 71 35 79 68 2 98 3 18 93 53 57 2 81 87 42 66 90 45 20 41 30 32 18 98 72 82 76 10 28 68 57 98 54 87 66 7 84 20 25 29 72 33 30 4 20 71 69 9 16 41 50 97 24 19 46 47 52 22 56 80 89 65

        And Your Code's output is:

        29 42 51 94 1 35 65 25 65 89 80 56 22 52 47 46 19 24 97 50 41 16 9 69 71 20 4 30 33 72 29 25 20 84 7 66 87 54 98 57 68 28 10 76 82 72 98 18 32 30 41 20 45 90 66 42 87 81 2 57 53 93 18 3 98 2 68 79 35 71 40 13 27 87 95 40 96
*/
public class RotateArray {
    static void rotateArr(int arr[], int d, int n)
    {
        int temp=0;
        if(d<arr.length-1){
            for(int i=0;i<arr.length-d;i++){
                temp = arr[(i+d)%arr.length];
                arr[(i+d)%arr.length] = arr[i];
                arr[i] = temp;
            }
            temp = arr[arr.length-1];
            for(int i=arr.length-1;i>arr.length-d-1;i--){
                arr[i] = arr[i-1];
            }
            arr[d+1] = temp;
        }
    }
    public static void reverse(int arr[], int l, int r) {
        while( l <= r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
    public static void rotateArray(int arr[],int d,int n){
        reverse(arr,0,n-1);
        reverse(arr,0,n-d-1);
        reverse(arr,d+1,n-1);
    }

    public  static  void main(String args[]){
        int arr[]= {1,2,3,4,5};
        int n=5;
        int d = 2;
        rotateArray(arr,d,n);
        for (int i : arr)
            System.out.print(i+" ");
    }
}
