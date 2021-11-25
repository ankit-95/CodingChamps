package com.codingchamps.Searching;

import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Vector;

public class MetaBinarysearch {

    public static int logn(int n)
    {
        int count = 0;
        while (n>0) {
            count++;
            n >>= 1;
        }
        return count;
    }
    // Function to show the working of Meta binary search
    static int bsearch(Vector<Integer> A, int key_to_search) {
        int n = (int) A.size();
        // Set number of bits to represent largest array index
        int no_of_bits = logn(n - 1);

        int pos = 0;
        for (int i = no_of_bits - 1; i >= 0; i--) {
            if (A.get(pos) == key_to_search) {
                return pos;
            }

            // Incrementally construct the
            // index of the target value
            int new_pos = pos | (1 << i);

            // find the element in one
            // direction and update position
            if ((new_pos < n) && (A.get(new_pos) <= key_to_search)) {
                pos = new_pos;
            }
        }

        // if element found return pos otherwise -1
        return ((A.get(pos) == key_to_search) ? pos : -1);
    }

    // Driver code
    static public void main(String[] args) {
        Vector<Integer> A = new Vector<Integer>();
        int[] arr = {-2, 10, 100, 250, 32315};
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        System.out.println(bsearch(A, 10));
    }
}
