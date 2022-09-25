class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        int xOrg = toBeRemoved[0];
        int yOrg = toBeRemoved[1];  
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            int x = intervals[i][0];
            int y = intervals[i][1];
            
            if(x > yOrg || y < xOrg){
                ans.add(Arrays.asList(x,y));   
            }
            else {
                if(x < xOrg){
                    ans.add(Arrays.asList(x,xOrg));   
                } 
                if(yOrg < y){
                    ans.add(Arrays.asList(yOrg,y));   
                } 
            }
        }
        return ans;
    }
}

