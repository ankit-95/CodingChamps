package com.codingchamps.RecursionProblems;

// Euclidean Algorithm works on two assumptions i.e
//1. if we subtract smaller number from larger number then GCD remains the same.
//        Therefore we keep on subtracting repeatedly until GCD in found.
//2. Now instead of subtraction, if we divide smaller number, the algorithm stops
//when we find the remainder 0.
public class EuclideanAlgorithm {
    // Remainder Logic
    public static int gcdByRemainder(int a,int b){
        if(a==0)
            return b;
        return gcdByRemainder(b%a,a);
    }

    // Subtraction Logic
    public static int gcdBySubtraction(int a,int b){
        if(a==0)
            return b;
        if(b==0)
            return a;
        if(a==b)
            return a;
        if(a>b)
            return gcdBySubtraction(a-b,b);
        else
            return gcdBySubtraction(a,b-a);

    }
}
