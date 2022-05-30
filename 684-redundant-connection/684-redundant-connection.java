class Solution {
    
    public int[] findRedundantConnection(int[][] edges) {
        int parent[] = new int[2001];
        for(int i=0;i<2001;i++)
            parent[i] = i;
        
        for(int[] edge : edges){
            int u = edge[0];   
            int v = edge[1];
            if(find(parent,u) == find(parent,v)) return edge;
            else
                parent[find(parent,u)] = find(parent,v);
        }
        
        return new int[2];
    }
    
    public int find(int parent[],int u){
        if(parent[u]!=u){
            parent[u] = find(parent,parent[u]);
        }
        return parent[u];
    }
}