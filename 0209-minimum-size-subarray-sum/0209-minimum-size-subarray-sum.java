class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum =0;
        int end = 0;
        int start =0;
        int minLen = Integer.MAX_VALUE;
        while(end<nums.length){
            if(sum<target){
                sum+=nums[end];
            }
            end++;
            while(sum>=target){
                if(end-start < minLen)
                    minLen = end-start;
                sum-=nums[start];
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}