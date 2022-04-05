class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] pos = new int[nums.length/2];
        int[] neg = new int[nums.length/2];
        int index1 =0,index2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                pos[index1++] = nums[i];
            } else {
                neg[index2++] = nums[i];
            }
        }
        index1 =0;
        index2=0;
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
               nums[i] = pos[index1++]; 
            } else {
               nums[i] = neg[index2++];
            } 
        }
        return nums;
    }
}