package com.codingchamps.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class NQueenProblem {

    public static boolean isSafe(int r,int c,int mat[][]){
        int duprow = r;
        int dupcol = c;
        while(r>=0 && c>=0){
            if(mat[r][c]==1) return false;
            r--; c--;
        }
        c = dupcol;
        r = duprow;
        while(c>=0){
            if(mat[r][c]==1) return false;
            c--;
        }
        c = dupcol;
        r = duprow;
        while(r<mat.length && c>=0){
            if(mat[r][c]==1) return false;
            r++;
            c--;
        }
        return true;
    }
    public static void solveProblem1(int c,int mat[][]){
        if(c==mat.length){
            for(int i=0;i<mat.length;i++){
                for(int j=0;j<mat.length;j++){
                    System.out.print(mat[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
            System.out.println();
            return;
        }
        for(int r=0;r<mat.length;r++){
            if(isSafe(r,c,mat)){
                mat[r][c] = 1;
                solveProblem1(c+1,mat);
                mat[r][c] = 0;
            }
        }
    }

    // Using Hashing
    public static void solveProblem2Util(int c,int mat[][],int leftRow[],int upperDiagonal[],int lowerDiagonal[]){
        if(c==mat.length){
            for(int i=0;i<mat.length;i++){
                for(int j=0;j<mat.length;j++){
                    System.out.print(mat[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
            System.out.println();
            return;
        }
        for(int row = 0;row<mat.length;row++){
            if(leftRow[row] ==0 && upperDiagonal[mat.length-1 + c - row]==0 && lowerDiagonal[c+row]==0){
                mat[row][c] = 1;
                leftRow[row] =1;
                upperDiagonal[mat.length-1 + c - row]=1;
                lowerDiagonal[c+row]=1;
                solveProblem2Util(c+1,mat,leftRow,upperDiagonal,lowerDiagonal);
                leftRow[row] =0;
                mat[row][c] = 0;
                upperDiagonal[mat.length-1 + c - row]=0;
                lowerDiagonal[c+row]=0;
            }
        }
    }

    public  static  void solveProblem2(int mat[][]){
        int leftRow[] = new int[mat.length];
        int upperDiagonal[] = new int[2*mat.length - 1];
        int lowerDiagonal[] = new int[2*mat.length - 1];
        solveProblem2Util(0,mat,leftRow,upperDiagonal,lowerDiagonal);
    }

    public static void main(String[] args) {
        int n =4;
        int matrix[][]= new int[n][n];
        List<int[][]> ans = new ArrayList<>();
        //solveProblem1(0,matrix);
        solveProblem2(matrix);
    }
}
