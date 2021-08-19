package com.codingchamps.Stack;

import java.util.Stack;

/*
* The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and
* we need to calculate span of stock’s price for all n days. The span Si of the stock’s price on a given day i is defined as,
* the maximum number of consecutive days just before the given day, for which the price of the stock on the current day is less than
* or equal to its price on the given day. For example,
*
* if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85},
* then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}
* */

public class StackSpanProblem {

    // This approach uses Stack , T.C = O(n) and Aux Space.C = O(n)
    /*
    A Linear-Time Complexity Method
    We see that S[i] on the day i can be easily computed if we know the closest day preceding i,
    such that the price is greater than on that day than the price on the day i. If such a day exists,
    let’s call it h(i), otherwise, we define h(i) = -1.
    The span is now computed as S[i] = i – h(i). See the following diagram.
    */
    private static void calculateStockSpan(int[] price, int[] s) {
        Stack<Integer> stock = new Stack<>();
        stock.push(0);

        s[0] =1;

        for(int i=1;i<price.length;i++){

            while(!stock.empty() && price[stock.peek()] <= price[i])
                    stock.pop();
            s[i] = stock.empty() ? (i+1) : (i - stock.peek());
            stock.push(i);
        }
    }

    public static void printStock(int s[]){
        System.out.print("{");
        for(int i=0;i<s.length-1;i++){
            System.out.print(s[i]+",");
        }
        System.out.print(s[s.length-1]);
        System.out.print("}");
    }

    public static void main(String args[]){

        int price[] = { 10, 4, 5 , 90, 120, 80 };
        int S[] = new int [price.length];

        calculateStockSpan(price, S);
        printStock(S);
    }


}

