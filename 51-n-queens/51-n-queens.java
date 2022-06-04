class Solution {
    
    public void helper(int c,char[][] mat,int leftRow[],int lowerDiagonal[],int upperDiagonal[],
                       int n,List<List<String>> ans){
        if(c==n){
            List<String> list = new ArrayList<>();
            for(char ch[] : mat){
                list.add(String.valueOf(ch));   
            }
            ans.add(list);
            return;
        }
        for(int row=0;row<n;row++){
            if(leftRow[row]==0 && lowerDiagonal[row+c]==0 && upperDiagonal[n-1+c-row]==0){
                leftRow[row]=1;
                lowerDiagonal[row+c]=1; 
                upperDiagonal[n-1+c-row]=1;
                mat[row][c] = 'Q';
                helper(c+1,mat,leftRow,lowerDiagonal,upperDiagonal,n,ans);
                leftRow[row]=0;
                lowerDiagonal[row+c]=0; 
                upperDiagonal[n-1+c-row]=0;
                mat[row][c] = '.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        int leftRow[] = new int[n];
        int lowerDiagonal[] = new int[2*n-1];
        int upperDiagonal[] = new int[2*n-1];
        char[][] mat = new char[n][n];
        for(int r=0;r<n;r++){   
            for(int c=0;c<n;c++){
                mat[r][c] = '.';
            }
        }
        List<List<String>> ans = new ArrayList();
        helper(0,mat,leftRow,lowerDiagonal,upperDiagonal,n,ans);
        return ans;
    }
}