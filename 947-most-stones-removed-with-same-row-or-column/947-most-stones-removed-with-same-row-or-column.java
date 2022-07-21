class Solution {
    public void dfs(int[] parent,int[][] stones, HashSet<int[]> vis){
        vis.add(parent);
        for(int stone[] : stones){
            if(!vis.contains(stone)){
                if(stone[0]==parent[0] || stone[1]==parent[1]){
                    dfs(stone,stones,vis);
                }
            }
        }
    }
    
    public int removeStones(int[][] stones) {
        HashSet<int[]> vis = new HashSet<>();
        int count=0;
        for(int stone[] : stones){
            if(!vis.contains(stone)){
                    dfs(stone,stones,vis);
                    count++;
                }
        }
        return stones.length - count;
    }
}