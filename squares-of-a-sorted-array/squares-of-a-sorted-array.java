class Solution {
    public int[] sortedSquares(int[] nums) {
        int start =0;
        int last = nums.length-1;
        int p=nums.length-1;
        int result[] = new int[nums.length];
        while(p>=0){
            if(Math.abs(nums[start]) >= Math.abs(nums[last])){
                result[p] = (int)Math.pow(nums[start],2);
                start++;
            }else {
                result[p] = (int)Math.pow(nums[last],2);
                last--;
            }
            p--;
        }
        
        return result;
    }
}