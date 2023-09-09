class Solution {
    public int helper(int index,int nums[],int target,int dp[][]){
        if(target==0){
            return 1;
        }
        if(dp[index][target]!=-1) return dp[index][target];
        int total=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] <= target){
                total+=helper(i,nums,target-nums[i],dp);
            }
        }
        return dp[index][target] = total;
    }
    public int combinationSum4(int[] nums, int target) {
        int dp[][] = new int[nums.length][target+1];
        for(int d[] : dp)
            Arrays.fill(d,-1);
        return helper(0,nums,target,dp);
    }
}