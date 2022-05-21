class Solution {
    
    // Recursion Solution
//     public int helper(int []coins,int amount,int n){
//         if(amount==0)
//             return 0;
//         if(n==0)
//             return 1;
//         int ans = helper(coins,amount,n-1);
//         if(coins[n] <= amount){
//             ans =  1 + helper(coins,amount-coins[n],n);
//         }
//         return ans;
//     }
    
//     public int coinChange(int[] coins, int amount) {
//         return helper(coins,amount,coins.length-1);
//     }
        public int coinChange(int[] coins, int amount) {
            if(amount<1) return 0;
            int[] dp = new int[amount+1];
            int sum = 0;

            while(++sum<=amount) {
                int min = -1;
                for(int coin : coins) {
                    if(sum >= coin && dp[sum-coin]!=-1) {
                        int temp = dp[sum-coin]+1;
                        min = min<0 ? temp : (temp < min ? temp : min);
                    }
                }
                dp[sum] = min;
            }
            return dp[amount];
        }
    }