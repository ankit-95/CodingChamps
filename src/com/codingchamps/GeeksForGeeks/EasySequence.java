package com.codingchamps.GeeksForGeeks;

/*
Geek recently started learning about sequences. He came across an easy sequence where Nth term is defined as :
        a(N) = a(N - 1) * a(N - 2) * a(N - 3) * ... * a(2) * a(1) * a(0) + 1 where a(0) = 2.
        As you are his firend, he challenged you to find the Nth term of this sequence. If you do so, Geek will consider that you are an expert in mathematics.
        As answer can be very large, find it modulo 109 + 7.


        Input:
        1. The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
        2. The first line of each test case contains one integer N.


        Output: For each test case, print the answer.


        Constraints:
        1. 1 ≤ T ≤ 10^5
        2. 1 ≤ N ≤ 10^5

        Input:
        2
        2
        3749
        Output:
        7
        317982199
        Explanation:
        Test Case 1 : a(0) = 2,
        a(1) = a(0) + 1 = 2 + 1 = 3
        a(2) = a(1) * a(0) + 1 = 3 * 2 + 1 = 7
 */
public class EasySequence {
    final static int max = 100000;
    static int[] cache = new int[max];
    static {
        cache[0]=2;
        cache[1] = 3;
    }
    public static int getProduct(int size){
        if(size==0){
            return 2;
        } else if(size==1){
            return 3;
        }

        else
           return 1 * getProduct(size-1);
    }
    public static int easySequence(int num,int k){
        if(k==0){
            return 2;
        }
        else if(k==1){
            return 3;
        }
        if (cache[k] != 0) {
            return cache[k];
        }
        cache[k]=1;
        for(int i= k-1;i>=0;i--){
            if (cache[i] != 0) {
                cache[k] = ((cache[k] % 1000000007) * (cache[i] % 1000000007)) % 1000000007;
            } else
            cache[k] = ((cache[k] % 1000000007) * (easySequence(num,i) % 1000000007) % 1000000007);
        }
        return  cache[k] + 1;
    }
    public static void main (String args[]){
      System.out.println(easySequence(3749,3749));
    }

}
