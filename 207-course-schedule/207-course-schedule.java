class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        int indegree[] = new int[n];
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<prerequisites.length;i++){
            indegree[prerequisites[i][0]]++;
            map.putIfAbsent(prerequisites[i][1], new ArrayList<>());
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0)
                q.add(i);
        }
        
        
        int count=0;
        while(!q.isEmpty()){
            int temp = q.remove();
            count++;
            for(int v : map.getOrDefault(temp, new ArrayList<>())){
                indegree[v]--;
                if(indegree[v]==0){
                    q.add(v);
                }
            }
        }
        //System.out.print(count+" "+n);
        return count==n;
    }
}