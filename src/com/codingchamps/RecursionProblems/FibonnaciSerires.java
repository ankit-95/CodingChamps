package com.codingchamps.RecursionProblems;

public class FibonnaciSerires {
    public static void fibonnaciIterative(int n){
        int a=0;
        int b=1;
        System.out.print("0 1 ");
        for(int i = 2;i<=n;i++){
            int c = a+b;
            System.out.print(c+" ");
            a = b;
            b = c;
        }
    }
    public static void fibonnaciRecursive(int n,int a,int b,int start){
        if(start>n){
            return;
        }
        int c = a+b;
        System.out.print(c+" ");
        fibonnaciRecursive(n,b,c,start+1);
    }
    public static int fibonnaciSumRecursive(int n){
        if(n==0){
            return 0;
        }
        else if(n==1)
        {
            return 1;
        }
        return fibonnaciSumRecursive(n-1) + fibonnaciSumRecursive(n-2);
    }
    public static void main(String args[]) {
        System.out.println("Iterative Approach : ");
        fibonnaciIterative(10);
        System.out.println("\nRecursive Approach : ");
        System.out.print("0 1 ");
        fibonnaciRecursive(10,0,1,2);
        System.out.println("\nRecursive Approach (Sum of first 10): ");
        System.out.println(fibonnaciSumRecursive(10));
    }
}
