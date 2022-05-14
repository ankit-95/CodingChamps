class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if(r*c != mat.length*mat[0].length)
            return mat;
        int res[][] = new int[r][c];
        int m = mat[0].length;
        for(int i=0;i<r*c;i++){
            res[i/c][i%c] = mat[i/m][i%m];
        }
        return res;
    }
}