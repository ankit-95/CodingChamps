package com.codingchamps.GeeksForGeeks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*Find duplicates in an array
        Given an array a[] of size N which contains elements from 0 to N-1, you need to find all the elements occurring more than once in the given array.

        Example 1:

        Input:
        N = 4
        a[] = {0,3,1,2}
        Output: -1
        Explanation: N=4 and all elements from 0
        to (N-1 = 3) are present in the given
        array. Therefore output is -1.
        Example 2:

        Input:
        N = 5
        a[] = {2,3,1,2,3}
        Output: 2 3
        Explanation: 2 and 3 occur more than once
        in the given array.*/
public class DuplicatesInArray {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(arr[i])){
                int count = map.get(arr[i]);
                map.put(arr[i],count+1);
            } else {
                map.put(arr[i],1);
            }
        }
        ArrayList<Integer> array = new ArrayList<>();

        for ( Map.Entry<Integer,Integer> e : map.entrySet()){
            if(e.getValue()!=1)
                array.add(e.getKey());
        }
        if(array.size()==0){
            array.add(-1);
        }
        Collections.sort(array);
        return array;
    }
    public static void main(String args[]) {
        int A[] = {2,3,1,2,3};
        int M=5;
        ArrayList<Integer> result  = duplicates(A,M);
        System.out.print(result+" ");

    }
}
