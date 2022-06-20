class Solution {
    public String longestCommonPrefix(String[] strs) {
        int lcp = 0;
        if(strs==null || strs.length==0)
            return "";
        
        if(strs.length==1)
            return strs[0];
        
        while(true){
            
            for(int i=0;i<strs.length;i++){
                if(strs[i]==null)
                    return "";
                if(lcp >= strs[i].length()){
                    return strs[i];
                }
                
                if(i>0 && strs[i].charAt(lcp)!= strs[i-1].charAt(lcp)){
                    return strs[i].substring(0,lcp);
                }
            }
            lcp++;
        }
    }
}