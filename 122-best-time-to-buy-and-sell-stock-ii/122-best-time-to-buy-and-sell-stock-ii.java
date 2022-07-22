class Solution {
    
    public int helper(int index,int[] prices,int turn,int dp[][]){
        if(index==prices.length){
            return 0;
        }
        if(dp[index][turn]!=-1) return dp[index][turn];
        int profit = 0;
        if(turn==1){
            profit += Math.max(helper(index+1,prices,turn,dp), -prices[index] +helper(index+1,prices,1-turn,dp));
        }
        else {
            profit += Math.max(helper(index+1,prices,turn,dp), +prices[index] +helper(index+1,prices,1-turn,dp));
        }
        return dp[index][turn] = profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length-1;
        int dp[][] = new int[n+1][2];
        for(int d[] : dp)
            Arrays.fill(d,-1);
        int ans = helper(0,prices,1,dp);       
        // for(int i=prices.length-1;i>=0;i--){
        //     for(int turn =1;turn >=0;turn--){
        //         System.out.print(dp[i][turn]+" ");
        //     }
        //     System.out.print("\n");
        // }
        return ans;
        
        // dp[n][0] = dp[n][1] = 0;
        // int profit = 0;
        // for(int i=n-1;i>=0;i--){
        //     for(int turn =0;turn <=1;turn++){
        //         if(turn==0){
        //             profit = Math.max(dp[i+1][0], -prices[i] + dp[i+1][1]);
        //         }
        //         if(turn==1) {
        //             profit = Math.max(dp[i+1][1], +prices[i] + dp[i+1][0]);
        //         }
        //         dp[i][turn] = profit;
        //     }
        // }
        // return dp[0][0];
    }
}