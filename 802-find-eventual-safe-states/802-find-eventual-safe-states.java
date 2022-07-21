class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        if(graph==null || graph.length==0) return res;
        
        int n = graph.length;
        int color[] = new int[n];
        for(int i=0;i<n;i++){
            if(dfs(graph,color,i)) res.add(i);
        }
        return res;
    }
    
    public boolean dfs(int[][] graph,int color[],int i){
        if(color[i]!=0) return color[i]==1;
        
        color[i]=2;
        for(int v : graph[i]){
            if(!dfs(graph,color,v)) return false;
        }
        color[i] = 1;
        return true;
    }
}