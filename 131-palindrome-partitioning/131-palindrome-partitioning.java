class Solution {
    public void helper(int index, String s,List<List<String>>  ans, List<String> list){
        if(index==s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                list.add(s.substring(index,i+1));
                helper(i+1,s,ans,list);
                list.remove(list.size()-1);    
            }
        }
    }
    
    public boolean isPalindrome(String s,int start,int end){
        while(start<=end){
            if(s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        helper(0,s,ans,new ArrayList<>());
        return ans;
    }
}