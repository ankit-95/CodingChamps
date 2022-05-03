class Solution {
    public int findUnsortedSubarray(int[] nums) {
        
        int n = nums.length;
        int max = nums[0];
        int min = nums[n-1];
        int beg = -1;
        int end = -2;
        
        for(int i=1;i<n;i++){
            max = Math.max(nums[i],max);
            min = Math.min(nums[n-1-i],min);
            
            if(nums[i] < max){
                end = i;
            } 
            if(nums[n-1-i] > min){
                beg = n-1-i;
            }
        }
        return end-beg+1;
    }
}