class Solution {
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<manager.length;i++){
            map.putIfAbsent(manager[i], new ArrayList<>());
            map.get(manager[i]).add(i);
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{headID,0});
        int time = 0;
        while(!q.isEmpty()){
            int u[]  = q.remove();
            int node = u[0];
            int timeReq = u[1];
            time = Math.max(time,timeReq);
            for(int v : map.getOrDefault(node,new ArrayList<>())){
                q.add(new int[]{v, timeReq + informTime[node]});
            }      
        }
        return time;
    }
}