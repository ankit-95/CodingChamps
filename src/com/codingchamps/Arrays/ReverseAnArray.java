package com.codingchamps.Arrays;

import javax.swing.*;
import java.util.Arrays;

public class ReverseAnArray {

    public static void reverseAnArray(){
        int ar[] = {1,2,3};
        int start=0, last = 0;
        for(start=0,last=ar.length-1; start< last/2;start++,last--){
            int temp = ar[start];
            ar[start] = ar[last];
            ar[last] = temp;
        }

        Arrays.stream(ar).forEach(e-> System.out.print(e+" "));
    }

    public static String reverseWord(String str){
        if(str.equals("")){
            return "";
        }
        String s = str.substring(0,1);
        return reverseWord(str.substring(1)) + s;
    }
    public static void main(String args[]){

        reverseAnArray();
        System.out.println(reverseWord("ankit"));
    }
}
