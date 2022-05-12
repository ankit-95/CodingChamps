class Solution {
    
     public void getPermutations(int index,int []nums, List<List<Integer>> ans, List<Integer> list, Map<Integer,Integer> count){
        if(index==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(Map.Entry<Integer,Integer> v : count.entrySet()){
            int num = v.getKey();
            int cout = v.getValue();
            if(cout==0) continue;
                count.put(num,cout-1);   
                list.add(num);
                getPermutations(index+1,nums,ans, list,count);
                count.put(num,cout);  
                list.remove(list.size()-1);
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer,Integer> count = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!count.containsKey(nums[i])){
                count.put(nums[i],0);
            }
            count.put(nums[i], count.get(nums[i])+1);
        }
        
        getPermutations(0,nums, ans, new ArrayList<>(), count);
        return ans;
    }
}