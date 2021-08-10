package com.codingchamps.RecursionProblems;

import java.math.BigInteger;

public class FactorialOfLargeNumber {

    public static BigInteger factorialUsingBigInteger(Integer num){
        if(num==1) {
            return new BigInteger("1");
        }
        return new BigInteger(String.valueOf(num)).multiply(factorialUsingBigInteger(num-1));
    }

    public static void factorialUsingArray(int num){

        int res_size = 1;
        int result[] =  new int[1000];
        result[0]=1;
        for(int x =2 ;x<=num;x++){
            res_size = factorial(x,result,res_size);
        }

        for(int i =res_size-1;i>=0;i--){
            System.out.print(result[i]+"");
        }
    }

    private static int factorial(int x, int[] result, int res_size) {
        int carry=0;

        for(int i=0;i<res_size;i++){
            int product = x * result[i] + carry;
            result[i] = product % 10;
            carry = product/10;
        }
        while(carry!=0){
            result[res_size] = carry % 10;
            carry = carry/10;
            res_size++;
        }
        return  res_size;
    }
}
