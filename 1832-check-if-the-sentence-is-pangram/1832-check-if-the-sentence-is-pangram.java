class Solution {
    public boolean checkIfPangram(String s) {
        int c[] = new int[26];
        for(int i=0;i<s.length();i++){
            c[s.charAt(i)-'a']=1;
        }
        
        for(int i=0;i<26;i++)
            if(c[i]==0)
                return false;
        return true;
    }
}