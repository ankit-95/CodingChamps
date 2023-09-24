class Solution {
    
    public boolean isCompareStrings(String s1, String s2){
        // if(f.length()!= s.length()+1) return false;
        // int i=0,j=0;
        // while(j<s.length()){
        //     if(f.charAt(i)==s.charAt(j)){
        //         i++;
        //         j++;
        //     }
        //     else 
        //         i++;
        // }
        // return (i==f.length() && j==s.length());
        if (s2.length() == s1.length()) return false;
            int diff = 0;
            for (int i = 0, j = 0; i < s1.length(); ) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    i++;
                    j++;
                } else {
                    diff++;
                    if (diff > 1) return false;
                    j++;
                }
            }
            return true;
    }
    
    public int longestStrChain(String[] words) {
        
        Arrays.sort(words, new Comparator<String>(){
            public int compare(String s1, String s2){
                return s1.length() - s2.length();
            }
        });
        
        for(String s : words)
            System.out.print(s+" ");
        
        int dp[] = new int[words.length];
        int maxi = 1;
        for(int i=0;i<words.length;i++){
            dp[i] = 1;
            for(int j=i-1;j>=0 && words[i].length() - words[j].length()<=1 ;j--){
                if(isCompareStrings(words[j],words[i])){
                    dp[i] = Math.max(dp[i],1 + dp[j]);
                }
                maxi = Math.max(maxi,dp[i]);
            }
        }
        return maxi;
    }
}