class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index]>0){
                nums[index]*=-1;
            }
        }
        
        for(int i=1;i<=nums.length;i++){
            
            if(nums[i-1]>0){
                ans.add(i);
            }
        }
        return ans;
    }
}