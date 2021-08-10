package com.codingchamps.RecursionProblems;

import java.math.BigInteger;

public class PowerFuntion {
    public static int power(int x,int y){
        if(y==0){
            return 1;
        }
        int ans = power(x,y-1);
        return x * ans;
    }
    /*
    This Method is also called fast Exponentiation for BigIntegers
     */
    public static BigInteger powerOfLog(int x, int y){
        if(y==0){
            return BigInteger.valueOf(1);
        }
        else if(y%2==0){
            BigInteger ans = powerOfLog(x,y/2);
            return ans.multiply(ans);
        }
        else {
            BigInteger ans = powerOfLog(x,y/2);
            return ans.multiply(ans.multiply(BigInteger.valueOf(x)));
        }
    }

    public static int modulus_expo(int a,int n, int noOfDigits){
        if(n==0){
            return 1;
        }
        if(n%2==0){
            int ans = modulus_expo(a,n/2,noOfDigits);
            return (ans * ans) % noOfDigits;
        } else {
            int ans = modulus_expo(a,n/2,noOfDigits);
            ans = (ans * ans) % noOfDigits;
            ans = (ans * a) % noOfDigits;
            return ans;
        }
    }
    public static void main(String args[]) {
        int x=5;
        int y=4;
        int power=1;
        System.out.println(Math.pow(x,y));// Through Libarary

        //Iterative Approach
        for(int i=1;i<=y;i++){
            power *=x;
        }
        System.out.println(power);// Through Iterative Approach of O(n)

        //Recursive Approach
        System.out.println(power(x,y));// Through Recursive Approach  of O(n)

        System.out.println(powerOfLog(x,y));// Through Recursive Approach  of O(log n)

        System.out.println(modulus_expo(x,y,100000));// Modulus Exponentiation to Get last Digits
    }
}
