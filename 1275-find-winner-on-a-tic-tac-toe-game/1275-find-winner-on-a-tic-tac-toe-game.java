class Solution {
    public String tictactoe(int[][] moves) {
        int n = 3;
        int rowVA[] = new int[3];
        int colVA[] = new int[3];
        int diaA[] = new int[2*3-1];
        int updiaA[] = new int[2*3-1];
        int rowVB[] = new int[3];
        int colVB[] = new int[3];
        int diaB[] = new int[2*3-1];
        int updiaB[] = new int[2*3-1];
        String winner = "A";
        boolean flag = true;
        int count=0;
        for(int values[] : moves){    
            int row = values[0];
            int col = values[1];
            
            if(flag){
                rowVA[row]++;
                colVA[col]++;
                diaA[row + col]++;
                updiaA[2 + col - row]++;
                if(rowVA[row]==3 || colVA[col]==3 || diaA[row + col]==3 || updiaA[2 + col - row]==3){
                    winner = "A"; 
                    return winner;
                }
            }
            else {
                rowVB[row]++;
                colVB[col]++;
                diaB[row + col]++;
                updiaB[2 + col - row]++;
                if(rowVB[row]==3 || colVB[col]==3 || diaB[row + col]==3 || updiaB[2 + col - row]==3){
                    winner = "B";    
                    return winner;
                }
            }
            
            flag = !flag;
        }
        if(moves.length==9)
            return "Draw";
        return "Pending";
    }
}