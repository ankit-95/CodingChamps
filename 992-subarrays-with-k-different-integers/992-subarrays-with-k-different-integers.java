class Solution {
    
    public int helper(int nums[],int k){
        Map<Integer,Integer> count = new HashMap<>();
        int ans = 0;
        int firstIdx = 0;
        for (int end = 0; end < nums.length; end++) {
            count.put(nums[end], count.getOrDefault(nums[end], 0) + 1);
            while (count.size() > k) {
                count.put(nums[firstIdx], count.get(nums[firstIdx]) - 1);
                if (count.get(nums[firstIdx]) == 0) {
                    count.remove(nums[firstIdx]);
                }
                firstIdx++;
            }
            ans += end-firstIdx+1;
        }
        return ans;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        
        return helper(nums,k) - helper(nums,k-1);
    }
}