class Solution {
    
    public int helper(int ind,int nums[],int dp[]){
        if(ind <= 0)
            return nums[0];
        if(dp[ind]!=-1)
            return dp[ind];
        int notPick = 0 + helper(ind-1,nums,dp);
        int pick = 0;
        if(ind>1)
            pick = nums[ind] + helper(ind-2,nums,dp);
        return dp[ind] = Math.max(pick,notPick);
    }
    public int rob(int[] nums) {
        int []dp = new int[nums.length+1];
        Arrays.fill(dp,-1);
        //return helper(nums.length-1,nums,dp);
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i=2;i<=nums.length;i++){
            int notPick = 0 + dp[i-1];
            int pick = 0;
            if(i>1)
                pick = nums[i-1] + dp[i-2];
            dp[i] = Math.max(pick,notPick);
        }
        return dp[nums.length];
    }
}