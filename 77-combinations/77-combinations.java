class Solution {
    public void helper(int index,int k,int n,List<Integer> list, List<List<Integer>> ans){
        if(index==n+1){
            if(list.size()==k){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        list.add(index);
        helper(index+1,k,n,list,ans);
        list.remove(list.size()-1);
        helper(index+1,k,n,list,ans);
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(1,k,n,new ArrayList<Integer>(),ans);
        return ans;
    }
}