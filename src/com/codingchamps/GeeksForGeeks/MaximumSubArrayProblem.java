package com.codingchamps.GeeksForGeeks;

public class MaximumSubArrayProblem {

    // Time Complexity = O(n*n)
    public static void naiveApproach(int ar[]) {
        int max = 0, sum = 0;
        //Naive Approach
        for (int i = 0; i < ar.length; i++) {
            sum = ar[i];
            for (int j = i + 1; j < ar.length; j++) {
                sum += ar[j];
                if (max < sum) {
                    max = sum;
                }
            }
        }
        System.out.println("Max is : " + max);
    }

    //Kadane's Algorithm, T.C = O(n)
    public static void kadaneAlgo(int ar[]) {
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

        for (int i = 0; i < ar.length; i++) {
            max_ending_here = max_ending_here + ar[i];
            if (max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
            }
            if (max_ending_here < 0) {
                max_ending_here = 0;
            }
        }
        System.out.println("Max is : " + max_so_far);
    }


    public static void main(String args[]) {

        int ar[] = {-2, 1, -3, 4, 5, 7, -6};
        naiveApproach(ar);
        kadaneAlgo(ar);
    }
}
