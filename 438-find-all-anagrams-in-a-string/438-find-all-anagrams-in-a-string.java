class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
        Map<Character,Integer> map = new HashMap<>();
        for(char c : p.toCharArray())
            map.put(c, map.getOrDefault(c,0)+1);
        int start =0;
        int end =0;
        int len = p.length();
        int count = map.size();
        while(end<s.length()){
            if(map.containsKey(s.charAt(end))){
                map.put(s.charAt(end),map.get(s.charAt(end))-1);
                if(map.get(s.charAt(end))==0)
                    count--;
            }
            
            end++;
            
            while(count==0){
                if(end-start==len){
                    list.add(start);
                }
                
                if(map.containsKey(s.charAt(start))){
                    map.put(s.charAt(start),map.get(s.charAt(start))+1);
                    if(map.get(s.charAt(start))>0)
                        count++;
                }
                start++;
            }
        }
        
            return list;
        }
}