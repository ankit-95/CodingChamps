package com.codingchamps.Arrays;

import java.util.Scanner;

public class ReverseSquaredSum {

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int size = sc.nextInt();
            int ar[] = new int[size];
            for(int i=0;i<size;i++){
                ar[i] = sc.nextInt();
            }
            int sign=1;
            int minus = -1;
            int sum = 0;
            for(int i=ar.length-1;i>=0;i--){
                sum +=  sign * ar[i] * ar[i];
                sign *= -1;
            }
            System.out.println(sum);
        }
    }
}
