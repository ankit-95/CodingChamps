class Solution {
    
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<int[]>((point1,point2) -> {
            return distance(point2[0],point2[1]) - distance(point1[0],point1[1]);
        });
        
        for(int i=0;i<points.length;i++){
            q.offer(new int[]{points[i][0],points[i][1]});
            if(q.size()>k){
                q.remove();
            }
        }
        
        int result[][] = new int[k][2];
        for(int i=0;i<k;i++){
            result[i] = q.remove();
        }
        return result;
    }
    
    public int distance(int a,int b){
        return a*a + b*b;       
    }
}