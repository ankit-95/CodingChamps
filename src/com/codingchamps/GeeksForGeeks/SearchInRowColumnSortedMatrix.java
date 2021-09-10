package com.codingchamps.GeeksForGeeks;

/*Given a matrix of size n x m, where every row and column is sorted in increasing order, and a number x.
Find whether element x is present in the matrix or not.
        Example 1:

        Input:
        n = 3, m = 3, x = 62
        matrix[][] = {{ 3, 30, 38},
        {36, 43, 60},
        {40, 51, 69}}
        Output: 0
        Explanation:
        62 is not present in the matrix,
        so output is 0.
        Example 2:

        Input:
        n = 1, m = 6, x = 55
        matrix[][] = {{18, 21, 27, 38, 55, 67}}
        Output: 1
        Explanation: 55 is present in the matrix.

        Your Task:
        You don't need to read input or print anything. Complete the function search() that takes n, m, x, and matrix[][] as input parameters and returns a boolean value. True if x is present in the matrix and false if it is not present.

        Expected Time Complexity: O(N + M)
        Expected Auxiliary Space: O(1)*/


public class SearchInRowColumnSortedMatrix {

    //Function to search a given number in row-column sorted matrix. ( Time Complexity : O(N + M) )
    static boolean search(int mat[][], int n, int m, int x)
    {
        int j=m-1;
        int i=0;
        while(i<n && j >=0){
            if(x == mat[i][j]){
                return true;
            }
            if(x < mat[i][j]){
                j--;
            }
            else
                i++;
        }
        return false;
    }

    public static void main(String args[]){
        int n = 1, m = 6, x = 55;
        int matrix[][] = {{18, 21, 27, 38, 55, 67}};

        System.out.println("Found : " + search(matrix,n,m,x));

        n = 3; m = 3; x = 62;
        int matrix2[][] = {{ 3, 30, 38},
            {36, 43, 60},
            {40, 51, 69}};
        System.out.println("Found : " + search(matrix2,n,m,x));
    }
}
