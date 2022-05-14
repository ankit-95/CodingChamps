class Solution {
    public int diagonalSum(int[][] mat) {
        int len = mat.length;
        int sum = 0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                if(i==j){
                    sum+=mat[i][j];
                }
                if((mat.length - 1 - j) == i){
                    sum+=mat[i][j];
                }
            }
        }
        return (len%2==0) ? sum : (sum - mat[(len-1)/2][(len-1)/2]);
    }
}