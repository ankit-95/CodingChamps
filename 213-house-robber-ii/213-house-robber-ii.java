class Solution {
    public int helper(int index,int nums[],int dp[]){
        if(index==0)
            return nums[0];
        if(index<0)
            return 0;
        if(dp[index]!=-1) return dp[index];
        int notPick = 0 + helper(index-1,nums,dp);
        int pick = nums[index] + helper(index-2,nums,dp);
        return dp[index] = Math.max(pick,notPick);
    }
    public int rob(int[] nums) {
        if(nums.length==1)
            return nums[0];
        int n = nums.length;
        int temp1[] = new int[n];
        int temp2[] = new int[n];
        
        for(int i=0;i<n;i++){
            if(i!=0)
                temp1[i] = nums[i];
            if(i!=n-1){
                temp2[i] = nums[i];
            }
        }
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        int left = helper(n-1,temp1,dp);
        Arrays.fill(dp,-1);
        int right = helper(n-1,temp2,dp);
        return Math.max(left,right);
    }
}