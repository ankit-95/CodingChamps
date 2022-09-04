class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for(String s : words){
            map.put(s,map.getOrDefault(s,0)+1);
        }
      //System.out.print(map);
        PriorityQueue<String> q = new PriorityQueue<>((a,b)->{
            if(map.get(a).equals(map.get(b))){
                return b.compareTo(a);
            }
            return map.get(a) - map.get(b);
        });
        
        for(String key : map.keySet()){
                q.add(key);
                if(q.size()>k)
                    q.remove();
        }
        
        List<String> ans = new ArrayList<>();
        for(int i=0;i<k;i++){
            ans.add(q.remove());
        }
        Collections.reverse(ans);
        return ans;
    }
}