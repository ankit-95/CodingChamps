class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int last = nums.length-1;
        while(start<=last){
            int mid = (start+last)/2;
            if(start==last) break;
            if(nums[start]<nums[last]) break;
            if(nums[mid] >= nums[start]){
                start = mid+1;
            } else 
                last = mid;
        }
        return nums[start];
    }
}