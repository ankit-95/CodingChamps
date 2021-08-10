package com.codingchamps.GeeksForGeeks;

import java.math.BigInteger;
import java.util.Scanner;
/*

Geek has been given three successive members of a sequence A ,B, C and his homework is to find the next term. The problem is that he forgot if his homework was on arithmetic progression or on geometric progression. Help him to determine the type of the progression (arithmetic or geometric) and hence the next successive member.

Input:

1. The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
2. The first line of each test case contains three space-separated integers A, B and C.

Output:
For each test case, print the 4th term.

Constraints:

1. 1 ≤ T ≤ 105
2. 1 ≤ A, B, C ≤ 109
Example:

Input:
2
2 4 8
1 2 3
Output:
16
4
Explanation:
Test Case 1 : It is a GP with common ratio 2.
        Input:

        3141 301536 28947456

        Its Correct output is:

        2778955776
 */

public class FindProgeression {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            BigInteger result;
            if((b-a)==(c-b)){
                result = BigInteger.valueOf(c).add(BigInteger.valueOf(b).
                        subtract(BigInteger.valueOf(a)));
                System.out.println(result);
            }else{
                BigInteger base  = BigInteger.valueOf((int)b/a);
                result = BigInteger.valueOf(a).multiply(base.pow(3));
                System.out.println(result);
            }
        }
    }
}
