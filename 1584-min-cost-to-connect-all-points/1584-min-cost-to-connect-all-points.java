class Solution {
    
    int parent[];
    public int find(int x){
        if(parent[x]!=x){
            return parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    public void union(int a,int b){
        parent[find(a)] = parent[find(b)];
    }
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                pq.add(new int[]{distance,i,j});
            }
       }
       parent = new int[points.length];
       for(int i=0;i<points.length;i++){
           parent[i] = i;
       } 
       int min = 0;
    //   System.out.print(pq); 
       int count = 0;
       while(count<points.length-1){
           int a[] = (int[]) pq.remove();
           int cost = a[0];
           if(find(a[1])!=find(a[2])){
               min+=cost;
               union(a[1],a[2]);
               count++;
           }
       }
        
       return min;
    }
}

