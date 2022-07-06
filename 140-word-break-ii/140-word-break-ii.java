class Solution {
    
    public List<String> helper(String s,List<String> wordDict,Map<String,List<String>> map){
        if(map.containsKey(s)){
            return map.get(s);  
        }
        
        List<String> res = new ArrayList<>();
        if(s.length()==0){
            res.add("");
            return res;
        } 
         
        for(String str : wordDict){
            if(s.indexOf(str)==0){
                String suffix = s.substring(str.length());
                List<String> subList = helper(suffix,wordDict,map);
                for(String s1 : subList)
                    res.add(str+(s1.isEmpty()?"":" ")+s1);
            }
        }
        map.put(s,res);
        return res;
    }
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<String,List<String>> map = new HashMap<>();
        return helper(s,wordDict,map);
    }
    
}