class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(m*n != original.length)
            return new int[0][0];
        int ar[][] = new int[m][n];
        int index = 0;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                if(index< original.length)
                    ar[i][j] = original[index++];
                else
                    ar[i][j] = 0;
            }
        return ar;
    }
}