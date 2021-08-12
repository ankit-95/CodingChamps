package com.codingchamps.RecursionProblems;

public class CountDigits {
    private static int count;
    private static int countDigits(long num){
        if(num==0)
            return 0;
        return  1 + countDigits(num/10);

    }

    private static void printNumbersDecreaseorder(int num){
        if(num==0)
            return;
        System.out.print(num+" ");
        printNumbersDecreaseorder(num-1);
    }

    private static void printNumbersIncreaseorder(int num){
        if(num==0)
            return;
        printNumbersIncreaseorder(num-1);
        System.out.print(num+" ");
    }
    public static void main(String args[]){
        System.out.println("Number of Digits : "+countDigits(1233682363));
        System.out.println("Numbers in Decreasing Order :");
        printNumbersDecreaseorder(10);
        System.out.println("\nNumbers in Increasing Order :");
        printNumbersIncreaseorder(10);
    }
}
