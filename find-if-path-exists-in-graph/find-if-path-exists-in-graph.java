class Solution {
    
    
    public boolean dfs(int src,boolean visited[],Map<Integer,List<Integer>> map,int destination){
        visited[src] = true;
        if(src==destination)
            return true;
        for(int v : map.getOrDefault(src,new ArrayList<>())){
            if(!visited[v]){
                if(dfs(v,visited,map,destination))
                    return true;
            } 
        }
        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer,List<Integer>> adj = new HashMap<>();
        for(int i=0;i<edges.length;i++){
            adj.putIfAbsent(edges[i][0],new ArrayList<>());
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.putIfAbsent(edges[i][1],new ArrayList<>());
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        boolean visited[] = new boolean[n];
        return dfs(source,visited,adj,destination);
    }
}