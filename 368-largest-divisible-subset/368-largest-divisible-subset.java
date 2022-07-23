class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp,1);
        int max =0;
        Arrays.sort(nums);
        int hash[] = new int[nums.length];
        int last = 0;
        for(int i=0;i<nums.length;i++){
            hash[i] = i;
            for(int prev =0;prev<i;prev++){
                if(nums[i] % nums[prev]==0 && dp[prev]+1 > dp[i]){
                    dp[i] = dp[prev]+1;
                    hash[i] = prev;
                }
                if(dp[i] > max){
                    max = dp[i];
                    last = i;
                }
                    
            }
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(nums[last]);
        while(last!=hash[last]){
            last = hash[last];
            ans.add(nums[last]);
        }
        return ans;
    }
}