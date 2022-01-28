package com.codingchamps.GeeksForGeeks;

public class SqureRoot {

    //ony Integral Part
    public static long sqrtApp1(long x){
        long start =0;
        long end =x;
        long ans = 0;
        while(start <=end){
            long mid = (start + end)/2;
            if(mid * mid == x){
                ans = mid;
                break;
            } else if(mid * mid < x){
                ans = mid;
                start = mid+1;
            }
            else end = mid-1;
        }
        return ans;
    }

    //Integral Part and fractional part
    public static float sqrtApp2(long x){
        long start =0;
        long end =x;
        float ans = 0;
        while(start <=end){
            long mid = (start + end)/2;
            if(mid * mid == x){
                ans = mid;
                break;
            } else if(mid * mid < x){
                ans = mid;
                start = mid+1;
            }
            else end = mid-1;
        }
        float inc = 0.1f;
        // upto 5 decimal places
        for(int i =0;i<5;i++){
            while(ans * ans <=x){
                ans+=inc;
            }
            // Loop terminates,
            // when ans * ans > number
            ans = ans -inc;
            inc = inc/10;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(sqrtApp1(78));
        System.out.println(sqrtApp2(78));
    }
}
