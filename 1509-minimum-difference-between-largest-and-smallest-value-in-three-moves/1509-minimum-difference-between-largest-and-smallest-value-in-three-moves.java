class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        // if less than 4 nums, we could check them to same num within 3 moves
        if (n <= 4) { return 0; }
        int min = Integer.MAX_VALUE;
        // sort to check n-th biggest and smallest 
        Arrays.sort(nums);
        // check 4 cases as a sliding window
        for (int i = 0; i < 4; i++) {
            // check 1st min, 4th max (think as - after 3 moves, set 1st~3rd max as the 4th max)
            // check 2st min, 3rd max (after 3 moves, set 1st~2nd max as 3rd max while 1st min as 2nd min)
            min = Math.min(min, nums[n - 4 + i] - nums[i]); 
        }
        return min;
    }
}