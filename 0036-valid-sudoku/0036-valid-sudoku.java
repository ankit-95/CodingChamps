class Solution {
    
    public boolean helper(char[][] board){
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                
                if(board[i][j] != '.') {
                    if(!valid(i, j, board,board[i][j])) {
                        return false;
                    }
                }
            }
        }
        return true; 
    }
    
    public boolean valid(int row,int col,char[][]board,char ch){
        for(int i=0; i<9; i++) {
            
            if(i != col && board[row][i] == ch) return false;
            
            if(i != row && board[i][col] == ch) return false;
            
            int l = 3 * (row / 3) + i / 3;
            int r = 3 * (col / 3) + i % 3;
            
            if(l != row && r != col) {
                if(board[l][r] == ch) return false;
            } 
                       
        }
        
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        return helper(board);
    }
}