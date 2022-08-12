class Solution {
    
    public boolean helper(int i,int j,int n,int m,char[][]board,String word, int index){
        if(index==word.length())
            return true;
        if(i<0|| i>=n || j<0 || j>=m || board[i][j]!=word.charAt(index))
            return false;
        board[i][j] = '*';
        boolean b1 = helper(i-1,j,n,m,board,word,index+1);
        boolean b2 = helper(i,j-1,n,m,board,word,index+1);
        boolean b3 = helper(i+1,j,n,m,board,word,index+1);
        boolean b4 = helper(i,j+1,n,m,board,word,index+1);
        if(b1 || b2 || b3 || b4){
                return true;
        }
        board[i][j] = word.charAt(index);
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(helper(i,j,n,m,board,word,0)){
                    return true;
                }
            }    
        }
        return false;
    }
}