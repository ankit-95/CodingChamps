package com.codingchamps.GeeksForGeeks;

public class SumOfNoInString {

    public static long findSum(String s)
    {
        long sum=0;
        long num=0;
        for(int i=0;i<s.length();i++){

            if(Character.isDigit(s.charAt(i))){
                num  = num * 10 + Long.valueOf(String.valueOf(s.charAt(i)));
            } else {
                sum +=num;
                num=0;
            }
        }
        return sum+num;
    }

    public static void main(String args[]){
        System.out.println(findSum("ge1eksg37e9eks9"));
    }
}
