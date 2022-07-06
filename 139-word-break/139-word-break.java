class Solution {
    
    public boolean helper(String s,List<String> wordDict,Map<String,Boolean> map){
        if(s.length()==0) return true;
        if(map.containsKey(s)) return map.get(s);
        
        for(String str : wordDict){
            if(s.indexOf(str)==0){
                String suffix = s.substring(str.length());
                boolean isPossible = helper(suffix,wordDict,map);
                map.put(suffix,isPossible);
                if(isPossible)
                    return true;
            }
        }
        
        map.put(s,false);
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String,Boolean> map = new HashMap<>();
        return helper(s,wordDict,map);
    }
}