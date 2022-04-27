class Solution {
    
    public void dfs(int[][] image,int newColor,int i,int j,int m,int n,int color){
        if(i<0 || i==m || j<0 || j==n || image[i][j]!=color){
            return;
        }
        image[i][j]=newColor;
        dfs(image,newColor,i-1,j,m,n,color);
        dfs(image,newColor,i,j+1,m,n,color);
        dfs(image,newColor,i,j-1,m,n,color);
        dfs(image,newColor,i+1,j,m,n,color);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]==newColor) return image;
        int m = image.length;            
        int n = image[0].length;
        dfs(image,newColor,sr,sc,m,n,image[sr][sc]);
        return image;
    }
}