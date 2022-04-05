class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        for(int i=0;i<n;i++){
            for(int j=0;2*j<n;j++){
                if(image[i][j] == image[i][n-1-j]){
                    image[i][j] = image[i][n-1-j] ^=1;
                }
            }
        }
        return image;
    }
}