class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        
        for(int i=1;i<=nums.length;i++){
            if(!set.contains(i)){
                ans.add(i);
            }
        }
        
        return ans;
    }
}