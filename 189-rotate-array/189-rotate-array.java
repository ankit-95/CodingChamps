class Solution {
    
    public void reverse(int nums[],int start,int last){
        while(start<last){
            int temp = nums[start];
            nums[start] = nums[last];
            nums[last] = temp;
            start++;
            last--;
        }
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums,0,nums.length-1);        
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
}