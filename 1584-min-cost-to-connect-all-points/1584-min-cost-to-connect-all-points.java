// class Solution {
    
//     int parent[];
//     public int find(int x){
//         if(parent[x]!=x){
//             return parent[x] = find(parent[x]);
//         }
//         return x;
//     }
    
//     public void union(int a,int b){
//         a = find(a);
//         b = find(b);
//         parent[b] = a;
//     }
//     public int minCostConnectPoints(int[][] points) {
//         TreeMap<Integer,List<Integer>> map = new TreeMap<>();
//         for(int i=0;i<points.length;i++){
//             for(int j=1;j<points.length && j!=i;j++){
//                 int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
//                 List list = new ArrayList<>();
//                 list.add(j);
//                 list.add(i);
//                 map.put(distance,list);
//             }
//        }
//        parent = new int[points.length];
//        for(int i=0;i<points.length;i++){
//            parent[i] = i;
//        } 
//        int min = 0;
//        System.out.print(map); 
//        for(Map.Entry<Integer,List<Integer>> pair : map.entrySet()){
//            int a = pair.getValue().get(0);
//            int b = pair.getValue().get(1);
//            int cost = pair.getKey();
//            if(parent[a]!=parent[b]){
//                min+=cost;
//                union(a,b);
//            }
//        }
        
//     return min;
//     }
// }

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length, ans = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                pq.add(new int[]{ findDist(points, i, j), i, j });
            }
        }
        int count = 0;
        UnionFind uf = new UnionFind(n);
        while(count < n-1) {
            int[] edge = pq.poll();
            if(uf.find(edge[1]) != uf.find(edge[2])) {
                ans += edge[0];
                count++;
                uf.union(edge[1], edge[2]);
            }
        }
        return ans;
    }
    private int findDist(int[][] points, int a, int b) {
        return Math.abs(points[a][0] - points[b][0]) + Math.abs(points[a][1] - points[b][1]);
    }
    class UnionFind {   
        int[] parent;
        UnionFind(int n) {
            this.parent = new int[n];
            for(int i = 0; i < n; i++) parent[i] = i;
        }		
        public void union(int a, int b) {
            parent[find(a)] = parent[find(b)];
        }
        public int find(int x) {
            if(parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }
    }
}