class Solution {
    public int[] sortArrayByParity(int[] nums) {
        Arrays.sort(nums);
        int ans[] = new int[nums.length];
        int low =0,high = nums.length-1;
        int index=0;
        while(low<=high){
            if(nums[index]%2==0){
                ans[low] = nums[index];
                low++;
            } else {
               ans[high] = nums[index];
                high--; 
            }
            index++;
        }
        return ans;
    }
}