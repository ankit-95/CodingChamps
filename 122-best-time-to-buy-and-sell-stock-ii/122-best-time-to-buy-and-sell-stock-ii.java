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
        int dp[][] = new int[prices.length+1][2];
        for(int d[] : dp)
            Arrays.fill(d,-1);
        return helper(0,prices,1,dp);       
    }
}