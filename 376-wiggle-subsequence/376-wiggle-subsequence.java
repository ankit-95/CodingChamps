class Solution {
    
    public int helper(int index,int nums[],int last,int dp[][]){
        if(index==nums.length){
            return 0;
        }
        if(dp[index][last]!=-1) return dp[index][last];
        int notInclude = helper(index+1,nums,last,dp);
        int next = last==1 ? 0 : 1;
        int include = 0;
        if(index>0){
            if(last==1 && nums[index] > nums[index-1] || last==0 && nums[index] < nums[index-1])
                include = 1 + helper(index+1,nums,next,dp);
        } else {
            include = 1 + helper(index+1,nums,next,dp);
        }
        return dp[index][last] = Math.max(include,notInclude);
    }
    public int wiggleMaxLength(int[] nums) {
        int dp[][] = new int[nums.length][2];
        for(int i=0;i<nums.length;i++)
            Arrays.fill(dp[i],-1);
        return Math.max(helper(0,nums,0,dp),helper(0,nums,1,dp));
    }
}