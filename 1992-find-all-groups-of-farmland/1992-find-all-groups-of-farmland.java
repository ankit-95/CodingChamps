class Solution {
    
    public void helper(int i,int j,int[][] land,List<Integer> cords){
        if(i<0 || i>=land.length || j<0 || j>=land[i].length || land[i][j]==0)
            return;
        land[i][j] = 0;
        cords.set(0,Math.min(cords.get(0),i));
        cords.set(1,Math.min(cords.get(1),j));
        cords.set(2,Math.max(cords.get(2),i));
        cords.set(3,Math.max(cords.get(3),j));
        
        helper(i-1,j,land,cords);
        helper(i+1,j,land,cords);
        helper(i,j-1,land,cords);
        helper(i,j+1,land,cords);
        
    }
    public int[][] findFarmland(int[][] land) {
        int n = land.length;
        int m = land[0].length; 
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(land[i][j]==1){
                    ArrayList<Integer> cords = new ArrayList<>();
                    cords.add(i);
                    cords.add(j);
                    cords.add(i);
                    cords.add(j);
                    helper(i,j,land,cords);
                    list.add(cords);
                }
            }
        }
        return list.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }
}