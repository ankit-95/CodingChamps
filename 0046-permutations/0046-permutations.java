class Solution {
    
    public void getPermutations(int index,int []nums, List<List<Integer>> ans){
        if(index==nums.length){
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<nums.length;i++)
                list.add(nums[i]);
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=index;i<nums.length;i++){
            swap(index,i,nums);
            getPermutations(index+1,nums,ans);
            swap(index,i,nums);    
        }
    }
    
    public void swap(int a,int b,int nums[]){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        getPermutations(0,nums, ans);
        return ans;
    }
}