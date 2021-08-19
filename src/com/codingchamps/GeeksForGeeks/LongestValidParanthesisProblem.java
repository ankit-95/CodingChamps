package com.codingchamps.GeeksForGeeks;

//Initial Template for Java

/*
Given a string S consisting of opening and closing parenthesis '(' and ')'. Find length of the longest valid parenthesis substring.

        Example 1:

        Input: S = ((()
        Output: 2
        Explaination: The longest valid
        parenthesis substring is "()".
        Example 2:

        Input: S = )()())
        Output: 4
        Explaination: The longest valid
        parenthesis substring is "()()".
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

class LongestValidParanthesisProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String S = in.readLine();

            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));
        }
    }
}

class Solution {
    static int maxLength(String s) {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.push(-1);
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                ad.push(i);

            else if (s.charAt(i) == ')')
                ad.pop();

            if (ad.isEmpty() == false) {
                int current = i - ad.peek();
                result = Math.max(result, current);

            } else ad.push(i);

        }
        return result;
    }
}