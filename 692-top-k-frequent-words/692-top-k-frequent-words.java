class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for(String s : words){
            map.put(s,map.getOrDefault(s,0)+1);
        }
      //System.out.print(map);
        PriorityQueue<String> q = new PriorityQueue<>((a,b)->{
            if(map.get(a)==map.get(b)){
                return a.compareTo(b);
            }
            return map.get(b) - map.get(a);
        });
        
        for(String key : map.keySet()){
                q.add(key);
        }
        
        List<String> ans = new ArrayList<>();
        for(int i=0;i<k;i++){
            ans.add(q.remove());
        }
        return ans;
    }
}