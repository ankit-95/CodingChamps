class Solution {
    
    public void sets(int index,int nums[],List<List<Integer>> ans,List<Integer> list){
        if(index==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        sets(index+1,nums,ans,list);
        list.add(nums[index]);
        sets(index+1,nums,ans,list);
        list.remove(list.size()-1);
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        sets(0,nums,ans,new ArrayList<>());
        return ans;
    }
}