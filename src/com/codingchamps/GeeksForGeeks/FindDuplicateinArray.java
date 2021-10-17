package com.codingchamps.GeeksForGeeks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindDuplicateinArray {

    //O(nlogn)
    public static int findDuplicateApp1(int ar[]){

        Arrays.sort(ar);
        int i=0;
        for(i =1;i<ar.length;i++){
            if(ar[i-1]==ar[i])
                break;
        }

        return ar[i];
    }

    // O(n) and Aux Space = O(n)
    public static int findDuplicateApp2(int ar[]){

        Set<Integer> s = new HashSet<>();

        for(int i =0;i<ar.length;i++){
            if(s.contains(ar[i]))
                return ar[i];
            s.add(ar[i]);
        }
        return -1;
    }

    // Using Floydd Warshell algo of Loop Detection

    public static int findDuplicateApp3(int ar[]){
        int i =ar[0];
        int j=ar[0];

        // Detec Loop
        while(true){
            i = ar[i];
            j = ar[ar[j]];
            if(i==j)
                break;
        }
        // Find the Index which is repeated
        i = ar[0];
        while(true){
            if(i==j)
                return i;
            i =ar[i];
            j =ar[j];
        }
    }

    public static void main(String[] args) {

        int ar[] = {1,3,4,2,3};
        System.out.print(findDuplicateApp3(ar));
    }
}
