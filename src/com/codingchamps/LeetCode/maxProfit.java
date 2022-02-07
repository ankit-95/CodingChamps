package com.codingchamps.LeetCode;


//Link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class maxProfit {

    public static int maxProfit(int[] prices) {
        int minNum = Integer.MAX_VALUE;
        int max = 0;
        for(int i=0;i<prices.length;i++){
            if(prices[i] < minNum){
                minNum = prices[i];
            }
            if(prices[i] - minNum > max){
                max = prices[i] - minNum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int prices[] = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
