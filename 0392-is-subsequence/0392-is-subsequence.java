class Solution {
    public boolean isSubsequence(String s, String t) {
        int p1 = 0;
        int p2 = 0;
        for(;p2<t.length();){
            if(p1<s.length() && s.charAt(p1)==t.charAt(p2)){
                p1++;
            }    
            p2++;
        }
        if(p1==s.length()){
            return true;
        }
        return false;
    }
}