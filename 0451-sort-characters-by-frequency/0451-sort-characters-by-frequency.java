class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        
        PriorityQueue<Map.Entry<Character,Integer>> q = new PriorityQueue<>(
        (a,b)-> b.getValue() - a.getValue());
        
        for(Map.Entry<Character,Integer> pair : map.entrySet()){
            q.add(pair);
        }
        
        String result = "";
        while(!q.isEmpty()){
            Map.Entry<Character,Integer> pair = q.remove();
            int val = pair.getValue();
            while(val-->0)
                result+=pair.getKey();
        }
        return result;
    }
}