class Solution {
    
    public int findParent(int i,int parent[]){
        if(parent[i]==i)
            return i;
        return parent[i] = findParent(parent[i],parent);
    }
    
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> ans = new ArrayList<>();    
        int parent[] = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
        boolean visited[] = new boolean[n];
        for(int i=0;i<edges.size();i++){
            List<Integer> curr = edges.get(i);
            int sv = curr.get(0);
            int ev = curr.get(1);
            if(visited[ev]) continue;
            sv = findParent(sv,parent);
            ev = findParent(ev,parent);
            parent[ev] = sv;
            visited[ev] = true;
        }
        
        for(int i=0;i<n;i++){
            if(parent[i]==i)
                ans.add(i);
        }
        return ans;
    }
}