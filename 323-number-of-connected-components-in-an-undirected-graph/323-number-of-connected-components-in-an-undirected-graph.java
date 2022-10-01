class Solution {
    
    public void dfs(int src,Map<Integer,ArrayList<Integer>> map,boolean visited[]){
        visited[src] = true;
        for(int v : map.getOrDefault(src, new ArrayList<>())){
            if(!visited[v]){
                dfs(v,map,visited);
            }
        }
    }
    
    public int countComponents(int n, int[][] edges) {
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            map.putIfAbsent(u,new ArrayList<>());
            map.putIfAbsent(v,new ArrayList<>());
            map.get(u).add(v);
            map.get(v).add(u);
        }
        
        boolean visited[] = new boolean[n];
        int count = 0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,map,visited);
                count++;
            }
        }
        
        return count;
    }
}