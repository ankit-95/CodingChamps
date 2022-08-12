class Solution {
     public void helper(int left,int right,String s,List<String> ans){
        
        if(left==0 && right==0) {
            ans.add(s);
            return;
        }
        if(left>0)
        helper(left-1,right,s+"(",ans);
        if(right>left)
        helper(left,right-1,s+")",ans);
    }
    
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(n,n,"",ans);
        return ans;
    }
}