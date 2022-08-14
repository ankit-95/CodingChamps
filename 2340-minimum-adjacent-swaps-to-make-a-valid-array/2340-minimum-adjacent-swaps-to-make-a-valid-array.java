class Solution {
    public int minimumSwaps(int[] nums) {
        int maxi = nums.length - 1, mini = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[maxi] < nums[nums.length - 1 - i]) {
                maxi = nums.length - 1 - i;
            }
            if (nums[mini] > nums[i]) {
                mini = i;
            }
        }
        return (nums.length - 1 - maxi) + mini - (mini > maxi ? 1 : 0);
    }
}