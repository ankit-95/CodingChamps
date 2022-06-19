class Solution {
    public int removeElement(int[] nums, int val) {
        int j =0;
        for(int i=0;i<nums.length;){
            if(nums[i]!=val){
                nums[j++] = nums[i++];
            } else{
                i++;  
            } 
        }
        return j;
    }
}