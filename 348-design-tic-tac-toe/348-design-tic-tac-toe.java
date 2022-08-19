class TicTacToe {
    
    int row1[];
    int col1[];
    int lowDia1[];
    int upDia1[];
    int row2[];
    int col2[];
    int lowDia2[];
    int upDia2[];
    int n;
    public TicTacToe(int n) {
        this.n = n;
        row1 = new int[n];
        col1 = new int[n];
        lowDia1 = new int[2*n-1];
        upDia1 = new int[2*n-1];
        row2 = new int[n];
        col2 = new int[n];
        lowDia2 = new int[2*n-1];
        upDia2 = new int[2*n-1];
    }
    
    public int move(int row, int col, int player) {
        if(player==1){
            row1[row] +=1;
            col1[col] +=1;
            lowDia1[row+col] +=1;
            upDia1[n-1+col-row] +=1;
        } else {
            row2[row] +=1;
            col2[col] +=1;
            lowDia2[row+col] +=1;
            upDia2[n-1+col-row] +=1;
        }
        
        if(row1[row]==n || col1[col]==n || lowDia1[row+col]==n || upDia1[n-1+col-row]==n)
            return 1;
        if(row2[row]==n || col2[col]==n || lowDia2[row+col]==n || upDia2[n-1+col-row]==n)
            return 2;
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */