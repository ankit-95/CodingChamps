class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 1;
        for(int j=0;j<nums.length;j++){
            if(j>0 && nums[j]!=nums[j-1]){
                nums[i++] = nums[j];
            }
        }
        return i;
    }
}