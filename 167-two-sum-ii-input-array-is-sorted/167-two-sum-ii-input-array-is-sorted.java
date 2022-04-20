class Solution {
    public int[] twoSum(int[] nums, int target) {
        int start = 0;
        int last = nums.length-1;
        while(start<last){
            if(nums[start] + nums[last] == target) break;
            else if(nums[start] + nums[last] < target)
                start++;
            else last--;
        }
        return new int[]{start+1,last+1};
    }
}