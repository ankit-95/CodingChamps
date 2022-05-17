class Solution {
    
    public boolean checkInc(int nums[]){
        int temp = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i] > nums[i-1])
                return false;
        }
        return true;
    }
    public boolean checkDec(int nums[]){
        int temp = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i] < nums[i-1])
                return false;
        }
        return true;
    }
    
    public boolean isMonotonic(int[] nums) {
        return checkInc(nums) || checkDec(nums);
    }
}