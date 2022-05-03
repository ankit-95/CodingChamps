class Solution {
    public int findUnsortedSubarray(int[] nums) {
        
          int temp[] = nums.clone();
          Arrays.sort(temp);
      
          int start = 0;
          while(start < nums.length && nums[start]==temp[start]) start++;

          int end = nums.length-1;
          while(end > start && nums[end]==temp[end]) end--;

          return end-start+1;
    }
}