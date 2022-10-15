class Solution {
    public String decodeMessage(String key, String message) {
        HashMap<Character,Integer> map = new HashMap<>();
        
        int idx = 0;
        for(int i=0;i<key.length();i++){
            if(idx < 26 && key.charAt(i)!=' ' && !map.containsKey(key.charAt(i))){
                map.put(key.charAt(i),idx);
                idx++;
            }
        }
        
        char ch[] = message.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(ch[i]!=' ')
                ch[i] = (char)(map.get(ch[i])+'a');
        }
        
        return String.valueOf(ch);
    }
}