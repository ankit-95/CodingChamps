class Solution {
    public int findLonelyPixel(char[][] picture) {
        int n = picture.length;
        int m = picture[0].length;
        int row[] = new int[n];    
        int col[] = new int[m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(picture[i][j]=='B'){
                    row[i]+=1;
                    col[j]+=1;
                }
            }
        }
        
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(picture[i][j]=='B' && row[i]==1 && col[j]==1){
                    count++;
                }
            }
        }
        return count;
    }
}