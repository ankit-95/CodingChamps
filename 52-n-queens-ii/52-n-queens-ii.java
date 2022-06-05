class Solution {
    
    int ans = 0;
    public void helper(int col,int n,int mat[][],int leftRow[],int upDiagonal[],int lowDiagonal[]){
        if(col==n){
            ans+=1;
            return;
        }
        for(int row=0;row<n;row++){
            if(leftRow[row]==0 && upDiagonal[n-1 - col + row]==0 && lowDiagonal[col + row]==0){
                leftRow[row] = 1;
                upDiagonal[n-1 - col + row] = 1;
                lowDiagonal[col + row] = 1;
                mat[row][col] = 0;                
                helper(col+1,n,mat,leftRow,upDiagonal,lowDiagonal);
                leftRow[row] = 0;
                upDiagonal[n-1 - col + row] = 0;
                lowDiagonal[col+row] = 0;
                mat[row][col] = 1;
            }
        }
    }
    public int totalNQueens(int n) {
        int mat[][] = new int[n][n];
        for(int i=0;i<n;i++){
           Arrays.fill(mat[i],1); 
        }
        int leftRow[] = new int[n];
        int upDiagonal[] = new int[2*n-1];
        int lowDiagonal[] = new int[2*n-1];
        helper(0,n,mat,leftRow,upDiagonal,lowDiagonal);
        return ans;
        
    }
}