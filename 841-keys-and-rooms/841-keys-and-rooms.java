class Solution {
    public void helper(int index,boolean vis[],List<List<Integer>> rooms){
        vis[index] = true;
        for(int v : rooms.get(index)){
            if(!vis[v])
                helper(v,vis,rooms);
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean vis[] = new boolean[n];
        helper(0,vis,rooms); 
        
        for(boolean f : vis){
            if(f==false)
                return false;
        }
        return true;
    }
}