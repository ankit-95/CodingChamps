class Solution {
    
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> ans = new ArrayList<>();    
        int nodes[] = new int[n];
        for(List<Integer> edge : edges){
            nodes[edge.get(1)]++;
        }
        for(int i=0;i<n;i++){
            if(nodes[i]==0)
                ans.add(i);
        }
        return ans;
    }
}