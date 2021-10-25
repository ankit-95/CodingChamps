package com.codingchamps.GeeksForGeeks;

public class SearchMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {

        int row = 0;
        int col = matrix[0].length-1;
        for(;row <matrix.length && col>=0; ){

            if(matrix[row][col] == target)
                return true;
            else if(matrix[row][col] < target)
                row++;
            else if(matrix[row][col] > target)
                col--;
        }
        return false;
    }

    public static void main(String[] args) {

        int matrix[][] = new int[3][4];

        int count=1;
        for(int i=0;i<3;i++)
            for(int j=0;j<4;j++)
                matrix[i][j] = count++;

        for(int i=0;i<3;i++){
            for(int j=0;j<4;j++)
                System.out.print(matrix[i][j]+" ");
            System.out.println();
        }

        System.out.println(searchMatrix(matrix,7));
        System.out.println(searchMatrix(matrix,17));

    }

}
