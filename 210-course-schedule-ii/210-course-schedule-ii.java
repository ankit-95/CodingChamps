class Solution {
    public int[] findOrder(int n, int[][] egdes) {
        int inDegree[] = new int[n];
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int edge[] : egdes){
            map.putIfAbsent(edge[1],new ArrayList<>());
            map.get(edge[1]).add(edge[0]);
            inDegree[edge[0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(inDegree[i]==0)
                q.add(i);
        }
        
        ArrayList<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int u = q.remove();
            topo.add(u);
            for(int v : map.getOrDefault(u,new ArrayList<>())){
                inDegree[v]--;
                if(inDegree[v]==0)
                    q.add(v);
            }
        }
        
        int ans[] = new int[topo.size()];
        for(int i=0;i<topo.size();i++)
            ans[i] = topo.get(i);
        return topo.size()==n ? ans : new int[0];
    }
}