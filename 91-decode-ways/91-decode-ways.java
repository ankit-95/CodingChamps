class Solution {
    public int helper(int index,String s,int dp[]){
        if(index==s.length()){
            return 1;   
        }
        if(s.charAt(index)=='0')
            return 0;
        if(index==s.length()-1)
            return 1;
        if(dp[index]>0) return dp[index];
        int ans =helper(index+1,s,dp);
        if(Integer.parseInt(s.substring(index,index+2))<=26) {
            ans += helper(index+2,s,dp);
        }
        return dp[index] = ans;
    }
    
    public int numDecodings(String s) {
        int dp[] = new int[s.length()+1];
        return helper(0,s,dp);
    }
}