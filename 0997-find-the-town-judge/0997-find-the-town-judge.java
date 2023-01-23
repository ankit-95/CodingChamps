class Solution {
    public int findJudge(int n, int[][] trust) {
        int  indeg[] = new int[n+1];
        int  outdeg[] = new int[n+1];
        
        Arrays.fill(indeg,1);
        Arrays.fill(outdeg,1);
        for(int i=0;i<trust.length;i++){
            outdeg[trust[i][0]]++;
            indeg[trust[i][1]]++;
        }
         
        for(int i=1;i<n+1;i++){
            if(outdeg[i]==1 && indeg[i]==n){
                return i;
            }
        }
        return -1;
        
    }
}