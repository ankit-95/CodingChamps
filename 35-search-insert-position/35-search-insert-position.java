class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int last = nums.length;
        while(start<last){
            int mid = (start + (last-start)/2);
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]<target){
                start = mid+1;
            } else 
                last = mid;
        }
        return start;
    }
}