class Solution {
    
    public int helper(int []cost, int index,int dp[]){
        if(index >=cost.length)
            return 0;
        if(dp[index]!=-1) return dp[index];
        int first = Integer.MAX_VALUE,second = Integer.MAX_VALUE;
        first = cost[index] + helper(cost,index+1,dp);
        second = cost[index] + helper(cost,index+2,dp);
        return dp[index] = Math.min(first,second);
    }
    public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int[cost.length+1];
        Arrays.fill(dp,-1);
        int min_a = helper(cost,0,dp);
        Arrays.fill(dp,-1);
        int min_b = helper(cost,1,dp);
        return Math.min(min_a,min_b);
    }
}