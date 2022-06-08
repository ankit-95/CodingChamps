class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int n = nums.length;
        int ans[] = new int[n];
        int runningPrefix = 1;
        for(int i=0;i<n;i++){
            ans[i] = runningPrefix; 
            runningPrefix*= nums[i];
        }
        int runningSuffix = 1;
        for(int i=n-1;i>=0;i--){
            ans[i] *= runningSuffix;
            runningSuffix*= nums[i];
        }
        return ans;
    }
}