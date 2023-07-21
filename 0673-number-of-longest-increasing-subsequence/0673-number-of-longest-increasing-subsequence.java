class Solution {
    public int findNumberOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp,1);
        int max =1;
        int hash[] = new int[nums.length];
        int count[] = new int[nums.length];
        Arrays.fill(count,1);
        for(int i=0;i<nums.length;i++){
            for(int prev =0;prev<i;prev++){
                if(nums[i] > nums[prev] && dp[prev]+1 > dp[i]){
                    dp[i] = dp[prev]+1;
                    count[i] = count[prev];
                }
                else if(nums[i] > nums[prev] && dp[prev]+1 == dp[i]){
                    dp[i] = dp[prev]+1;
                    count[i] += count[prev];
                }
                if(dp[i] > max){
                    max = dp[i];
                }
            }
        }
        System.out.println(max);
        int ans = 0;
        for(int i=0;i<dp.length;i++){
          if(dp[i]==max)
              ans+=count[i];
        }
        return ans;
    }
}