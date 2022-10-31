class Solution {
    public boolean isToeplitzMatrix(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        
        if(r==1 || c==1)
            return true;
        int lower[] = new int[r*c-1];    
        
        Arrays.fill(lower,-1);
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(lower[c-1 + i - j]!=-1 && lower[c-1 + i - j]!=mat[i][j]){
                    return false;
                } else if(lower[c-1 + i - j]==-1){
                    lower[c-1 + i - j]=mat[i][j];
                }
            }
        }
        
        return true;                                                  
    }
}