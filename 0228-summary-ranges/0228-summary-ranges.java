class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        
        if(nums.length==0){
            return ans;
        }
        int start = nums[0];
        int last =  nums[0];
        for(int i=1;i<nums.length;i++){
            if(Math.abs(nums[i-1] - nums[i])==1){
                last = nums[i];                
            } else {
                if(start==last){
                   ans.add(String.valueOf(start)); 
                } else {
                   ans.add(String.valueOf(start)+"->"+String.valueOf(last)); 
                }
                start = nums[i];
                last = nums[i];
            }
        }
        if(start==last){
            ans.add(String.valueOf(last)); 
        } else {
            ans.add(String.valueOf(start)+"->"+String.valueOf(last)); 
        }
        return ans;
    }
}