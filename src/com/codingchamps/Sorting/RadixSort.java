package com.codingchamps.Sorting;

import java.util.Arrays;


/*What if the elements are in the range from 1 to n2?
        We can’t use counting sort because counting sort will take O(n2) which is worse than comparison-based sorting algorithms.
        Can we sort such an array in linear time?

        Radix Sort is the answer. The idea of Radix Sort is to do digit by digit sort starting from least significant digit to most significant digit. Radix sort uses counting sort as a subroutine to sort.
What is the running time of Radix Sort?
        Let there be d digits in input integers. Radix Sort takes O(d*(n+b)) time where b is the base for representing numbers,
        for example, for the decimal system, b is 10. What is the value of d? If k is the maximum possible value, then d would be O(logb(k)).
        So overall time complexity is O((n+b) * logb(k)). Which looks more than the time complexity of comparison-based sorting algorithms
        for a large k. Let us first limit k. Let k <= nc where c is a constant. In that case, the complexity becomes O(nLogb(n)).
        But it still doesn’t beat comparison-based sorting algorithms.
        What if we make the value of b larger?. What should be the value of b to make the time complexity linear?
        If we set b as n, we get the time complexity as O(n). In other words, we can sort an array of integers with a range from 1 to nc
        if the numbers are represented in base n (or every digit takes log2(n) bits).*/
// T.C  : O((n+b) * logb(k))
public class RadixSort {


    public static void countSort(int ar[], int n, int exp){

        int count[] = new int[10];
        int output[] = new int[n];

        for(int i=0;i<10;i++)
            count[i]=0;

        for(int i=0;i<n;i++){
            ++count[ar[i]/exp % 10];
        }

        for(int i=1;i<10;i++){
            count[i] += count[i-1];
        }

        for(int i=n-1;i>=0;i--){
            output[count[ar[i]/exp % 10]-1] = ar[i];
            --count[ar[i]/exp % 10];
        }

        for(int i=n-1;i>=0;i--){
            ar[i] = output[i];
        }
    }
    public static void radixSort(int ar[],int n){

        int max = Arrays.stream(ar).max().getAsInt();

        for(int exp =1; max/exp > 0 ; exp*=10){
            countSort(ar,n,exp);
        }

        Arrays.stream(ar).forEach(e-> System.out.print(e+" "));
    }
    public static void main(String args[]){

        int ar[] = {890,30,23,467,578,12,34};

        radixSort(ar,ar.length);

    }
}
