class Solution {
    
    public void helper(int src,int[][] isConnected,boolean[] visited){
        visited[src] = true;
        for(int i=0;i<isConnected[src].length;i++){
            if(isConnected[src][i]==1 && !visited[i]){
                helper(i,isConnected,visited);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        boolean visited[] = new boolean[isConnected.length];
        int count=0;
        for(int i=0;i<isConnected.length;i++){
            if(!visited[i]){
                count++;
                helper(i,isConnected,visited);
            }
        }
        return count;
    }
}