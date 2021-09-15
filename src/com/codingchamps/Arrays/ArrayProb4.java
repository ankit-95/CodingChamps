package com.codingchamps.Arrays;

import java.lang.reflect.Array;
import java.util.*;

/*Arrange given numbers to form the biggest number | Set 1
        Difficulty Level : Medium
        Last Updated : 19 Jan, 2021
        Given an array of numbers, arrange them in a way that yields the largest value. For example,
        if the given numbers are {54, 546, 548, 60}, the arrangement 6054854654 gives the largest value.
        And if the given numbers are {1, 34, 3, 98, 9, 76, 45, 4}, then the arrangement 998764543431 gives the largest value.
        */
public class ArrayProb4 {

    public static void usingArrayList() {
        ArrayList<String> ar = new ArrayList<>();
        ar.add("54");
        ar.add("546");
        ar.add("548");
        ar.add("60");

        Collections.sort(ar, new Comparator<String>() {
            @Override
            public int compare(String X, String Y) {
                String XY = X + Y;
                String YX = Y + X;
                return XY.compareTo(YX) > 0 ? -1 : 1;
            }
        });

        Iterator itr = ar.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next());
        }
    }

    public static void usingArrayOnly() {
        String ar[] = {"54", "546", "548", "60"};
        Arrays.sort(ar, new Comp());
        String result = "";
        for (String s : ar) {
            result += s;
        }
        System.out.println(result);
    }

    static class Comp implements Comparator<Object> {

        public int compare(Object o1, Object o2) {
            String X = (String) o1;
            String Y = (String) o2;

            String XY = X + Y;
            String YX = Y + X;

            return XY.compareTo(YX) > 0 ? -1 : 1;
        }
    }

    public static void main(String args[]) {
        //usingArrayList();
        usingArrayOnly();
    }
}
