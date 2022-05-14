class Solution {
    public int diagonalSum(int[][] mat) {
        int len = mat.length;
        int sum = 0;
        for(int i=0;i<mat.length;i++){
            sum+=mat[i][i];
            sum+=mat[i][mat.length - 1 - i];
        }
        return (len%2==0) ? sum : (sum - mat[(len-1)/2][(len-1)/2]);
    }
}