class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n == 1 && edges.length == 0)
		    return true;
	    if (edges.length != n - 1)
		    return false;
        Map<Integer,HashSet<Integer>> map = new HashMap<>();
        Map<Integer,Integer> indegree = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<>());
            indegree.put(i, 0);
	    }
        for(int []u: edges){
                map.get(u[0]).add(u[1]);
                map.get(u[1]).add(u[0]);
                indegree.compute(u[0],(k,v)-> v+1);
                indegree.compute(u[1],(k,v)-> v+1);
        }        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree.get(i)==1)
                q.add(i);
        }
        
        int count=0;
        while(!q.isEmpty()){
            int u = q.remove();
            count++;
            for(int v : map.get(u)){
                indegree.compute(v, (k, val) -> val - 1);
                if(indegree.get(v)==1){
                    q.add(v);
                }
            }
        }
        return count==n;
    }
}