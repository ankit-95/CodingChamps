class Solution {
    
    public void helper(int target, int k,List<Integer> list, int start,List<List<Integer>> ans){
        if(k==0){
            if(target==0)
                ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=start;i<=9;i++){
            int diff = target - i;
            list.add(i);
            helper(diff,k-1,list,i+1,ans);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList();
        helper(n,k,new ArrayList(),1,ans);
        return ans;
    }
}