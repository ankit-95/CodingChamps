class Solution {
    public int parent[];
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        parent = new int[s.length()];
        for(int i=0;i<s.length();i++)
            parent[i] = i;
        
        for(List<Integer> l : pairs){
            union(l.get(0),l.get(1));
        }
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            int root = find(i);
            map.putIfAbsent(root,new PriorityQueue<>());
            map.get(root).offer(s.charAt(i));
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            sb.append(map.get(find(i)).poll());
        }
        return sb.toString();
    }
    
    public int find(int a){
        if(parent[a]!=a){
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }
    public void union(int a,int b){
        a = find(a);
        b = find(b);
        if(a<b){
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
}