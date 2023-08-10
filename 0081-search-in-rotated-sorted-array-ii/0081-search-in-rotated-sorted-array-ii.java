class Solution {
    public boolean search(int[] nums, int target) {
        int left=0;
        int right = nums.length;
        while(left < right){
            int mid = left + (right -left)/2;
            if(nums[mid] == target) return true;
            if(nums[mid] > nums[left]){ // cause mid can equals to left
                if(nums[left] <= target && target < nums[mid]){
                    right = mid;
                }else{
                    left = mid +1;
                }
            }else if(nums[mid] < nums[left]){
                if(nums[mid] < target && target < nums[left]){
                    left = mid +1;
                }else{
                    right = mid;
                }
            } else 
                left++;
        }
        return false;
    }
}
