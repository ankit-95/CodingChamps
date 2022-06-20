class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<t.length();i++)
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i),0)+1);
        
        int end = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        int count = map.size();
        String ans = "";
        while(end < s.length()){
            if(map.containsKey(s.charAt(end))){
                map.put(s.charAt(end), map.getOrDefault(s.charAt(end),0)-1);
                if(map.get(s.charAt(end))==0)
                    count--;
            }
            
            end++;
            
            while(count==0){
                
                if(end-start < len){
                    len = end-start;
                  //  System.out.println(start+" "+end);
                    ans = s.substring(start,end);
                }
                
                if(map.containsKey(s.charAt(start))){
                    map.put(s.charAt(start), map.getOrDefault(s.charAt(start),0)+1);
                    if(map.getOrDefault(s.charAt(start),0)>0){
                        count++;
                    }
                }
                start++;
            }
        }
        
        return ans;
    }
}