class Solution {
    
    public int signFunc(int num){
        if(num>0)
            return 1;
        else if(num<0)
            return -1;
        return 0;
    }
    
    public int helper(int nums[],int len){
        if(len==nums.length)
            return 1;
        return signFunc(nums[len]) * helper(nums,len+1);
    }
    public int arraySign(int[] nums) {
        return helper(nums,0);
    }
}