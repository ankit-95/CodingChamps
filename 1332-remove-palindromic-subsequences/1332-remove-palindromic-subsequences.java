class Solution {
    public int removePalindromeSub(String s) {
        for(int i=0,j=s.length()-1;i<j;){
            if(s.charAt(i)== s.charAt(j)){
                i++;
                j--;    
            }
            else 
                return 2;
        }
        return 1;
    }
}