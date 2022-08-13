class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || words == null || s.length() == 0 || words.length == 0) {
            return new ArrayList<>();
        }
        Map<String,Integer> counts = new HashMap<>();
        for(String s1 : words){
            counts.put(s1, counts.getOrDefault(s1,0)+1);
        }
        int slen = s.length();
        int wordLen = words[0].length();
        int len = words.length;
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<slen - len*wordLen+1;i++){
            String sub = s.substring(i,i+wordLen*len);
            if(isConcat(sub,counts,wordLen)){
                res.add(i);
            }
        }
        return res;
    }
    
    public boolean isConcat(String s,Map<String,Integer> counts, int len){
        Map<String,Integer> seen = new HashMap<>();
        for(int i=0;i<s.length();i+=len){
            String sub = s.substring(i,i+len);
            seen.put(sub, seen.getOrDefault(sub,0)+1);
        }
        return seen.equals(counts);
    }
}