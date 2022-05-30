class Solution {
    public int minReorder(int n, int[][] connections) {
        HashSet<String> set = new HashSet<>();
        Map<Integer,Set<Integer>> map = new HashMap<>();
        boolean visited[] = new boolean[n];
        for(int c[] : connections){
            int u = c[0];
            int v = c[1];
            set.add(u+","+v);
            
            map.putIfAbsent(u,new HashSet());
            map.get(u).add(v);
            map.putIfAbsent(v,new HashSet());
            map.get(v).add(u);
        }
        
        return dfs(0,map,set,visited);
    }
    
    public int dfs(int src,Map<Integer,Set<Integer>> map,HashSet<String> set,boolean visited[]){
        int count=0;
        if(visited[src])  return 0;
        visited[src] = true;
        for(int v : map.getOrDefault(src,new HashSet<>())){
            if(visited[v]) continue;
            if(!set.contains(v+","+src))  count++;
            count += dfs(v,map,set,visited);
        }
        return count;
    }
}