class Solution {
    
    
    public boolean helper(int rowst, int rowe, int colst, int cole,int mat[][], int target){
        if(rowst>rowe || colst> cole)
            return false;
        
        int rowmid = rowst + (rowe - rowst) / 2;
        int colmid = colst + (cole - colst) / 2;
        
        if(mat[rowmid][colmid]==target)
            return true;
        else if(mat[rowmid][colmid]>target){
            return helper(rowst, rowmid-1, colst, colmid-1,mat,target) ||
                helper(rowst, rowmid-1, colst, cole,mat,target) || 
                helper(rowst, rowe, colst, colmid-1,mat,target);
        }
        else{
             return helper(rowmid+1, rowe, colmid+1, cole,mat,target) ||
                helper(rowmid+1, rowe, colst, cole,mat,target) || 
                helper(rowst, rowe, colmid+1, cole,mat,target);
        }
    }
    public boolean searchMatrix(int[][] matrix, int target) {
         if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        return helper(0,m-1,0,n-1,matrix,target);
    }
}