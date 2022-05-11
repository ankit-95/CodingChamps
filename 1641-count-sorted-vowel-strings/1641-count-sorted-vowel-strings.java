class Solution {
    public String ar[] = {"a","e","i","o","u"};
    public void helper(int k,int start,String s,List<String> ans){
        if(k==0){
            {
                ans.add(s);
            }
            return;
        }
        for(int i=start;i<ar.length;i++){
            helper(k-1,i,s+ar[i],ans);
        }
    }
    public int countVowelStrings(int n) {
        List<String> ans = new ArrayList<>();
        helper(n,0,"",ans);
        return ans.size();
    }
}