package com.codingchamps.HackerRank;

import java.util.ArrayList;
import java.util.List;

public class DiagonalDifference {

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int size = arr.size();
        int diagonal =0;
        int Oppdiagonal = 0;
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(i==j){
                    diagonal+= arr.get(i).get(j);
                }
                if(j==(size-i-1)){
                    Oppdiagonal+= arr.get(i).get(j);
                }
            }
        }
        return Math.abs(diagonal-Oppdiagonal);
    }

    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();

        l1.add(11);
        l1.add(2);
        l1.add(4);
        arr.add(l1);

        l1 = new ArrayList<>();

        l1.add(4);
        l1.add(5);
        l1.add(6);
        arr.add(l1);

        l1 = new ArrayList<>();

        l1.add(10);
        l1.add(8);
        l1.add(-12);
        arr.add(l1);

        System.out.println(diagonalDifference(arr));
    }
}
