class Solution {
    public boolean isBipartite(int[][] graph) {
        int color[] = new int[graph.length];
        Arrays.fill(color,-1);
        for(int i=0;i<graph.length;i++){
            if(color[i]==-1)
                if(!isBipartiteUtil(graph,i,color))
                    return false;
        }
        return true;
    }
    
    public boolean isBipartiteUtil(int [][]G, int src,int color[]){
        
        color[src] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        
        while(!q.isEmpty()){
            int u = q.poll();
            for(int v : G[u]){
                if(color[v]==-1){
                    color[v] = 1-color[u];
                    q.add(v);
                } else if(color[v]==color[u])
                    return false;
            }
        }
        return true;   
    }
}