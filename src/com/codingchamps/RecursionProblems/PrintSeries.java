package com.codingchamps.RecursionProblems;
import java.util.*;
/*Problem Statement
        You have given two positive integers N and K. Your task is to print a series of numbers i.e subtract K from N until it becomes 0 or negative then add K until it becomes N. You need to do this task without using any loop.
        For Example:
        For  N = 5 , K = 2
        Series = [ 5, 3, 1, -1, 1, 3, 5]
        Input Format :
        The first line of input contains a single integer T, representing the number of test cases or queries to be run

        The first line of each test contains two space-separated integers N and K.
        Output Format :
        For each test case, print a single line containing the required series.
        Note:
        You do not need to print anything, it has already been taken care of. Just implement the given function.
        Constraints :
        1 <= T <= 100
        1 <= N <= 3000
        1 <= K <= N

        Time Limit: 1sec
        Sample Input 1 :
        2
        3 2
        5 4
        Sample Output 1 :
        3 1 -1 1 3
        5 1 -3 1 5


        */
public class PrintSeries {
    static List<Integer> list;
    public static void computeSeriesList(int n,int k){
        if(n<=0){
            list.add(n);
            return;
        }
        list.add(n);
        computeSeriesList(n-k,k);
        list.add(n);
    }
    public static List<Integer> printSeries(int n, int k) {
        list = new ArrayList<Integer>();
        computeSeriesList(n,k);
        return list;
    }
    public static void main(String args[]) {
        List<Integer> list = printSeries(5,2);
        System.out.print(list);
    }
}
