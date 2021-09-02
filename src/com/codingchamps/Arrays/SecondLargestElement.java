package com.codingchamps.Arrays;

import java.util.Arrays;

public class SecondLargestElement {

    public static void main(String args[]){

        int ar[] = {1,1,1,1,1};
        int max1,max2;
        max1 = max2 = Integer.MIN_VALUE;
        for(int i=0;i<ar.length;i++){
            if(ar[i] > max1){
                max2 = max1;
                max1 = ar[i];
            }
            if(ar[i]!= max1 && ar[i] > max2){
                max2= ar[i];
            }
        }
        System.out.println("1st Largest : "+ max1 + " \n2nd Largest : " + ((max2==Integer.MIN_VALUE)? -1 : max2));
    }
}
