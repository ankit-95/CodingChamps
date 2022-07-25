class Solution {
    
    public boolean bfs(int src,int color[],Map<Integer,List<Integer>> map){
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        color[src] = 1;
        while(!q.isEmpty()){
            int u = q.poll();
            for(int v : map.getOrDefault(u, new ArrayList<>())){
                if(color[v]==-1){
                    color[v] = 1 - color[u];
                    q.add(v);
                } else if(color[v] ==color[u])
                    return false;
            }
        }
        return true;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        if(n==1 || dislikes==null || dislikes.length==0) return true;
        int color[] = new int[n+1];
        Arrays.fill(color,-1);
        
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int d[] : dislikes){
            map.putIfAbsent(d[0], new ArrayList<>());
            map.get(d[0]).add(d[1]);
            map.putIfAbsent(d[1], new ArrayList<>());
            map.get(d[1]).add(d[0]);
        }
        
        for(int i=1;i<=n;i++){
            if(color[i]==-1){
                if(!bfs(i,color,map))
                    return false;
            }
        }
        return true;
    }
}