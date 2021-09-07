package com.codingchamps.HackerRank;

public class StairCase {

    public static void staircase(int n) {
        // Write your code here
        for(int i=0;i<n;i++){
            for(int j=n-1;j>i;j--){
                System.out.print(" ");
            }
            for(int j=0;j<=i;j++){
                System.out.print("#");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        StairCase.staircase(6);
    }
}
