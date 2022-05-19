class Solution {
    // Matrix based solution but more space is consumed.
    // public List<List<Integer>> generate(int numRows) {
    //     int mat[][] = new int[numRows][numRows];
    //     for(int i=0;i<numRows;i++){
    //         mat[i][0] = 1;
    //         mat[0][i] = 1;
    //     }
    //     for(int i=1;i<numRows;i++){
    //         for(int j=1;j<numRows;j++){
    //             mat[i][j] = mat[i-1][j] + mat[i][j-1];
    //         }    
    //     }
    //     List<List<Integer>> ans = new ArrayList<>();
    //     for(int i=0;i<numRows;i++){
    //         List<Integer> list = new ArrayList<>();
    //         for(int j=0;j<=i;j++){
    //             list.add(mat[i-j][j]);
    //         }    
    //         ans.add(new ArrayList<>(list));
    //     }
    //     return ans;
    // }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res,prev = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            res = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i)
                    res.add(1);
                else 
                    res.add(prev.get(j) + prev.get(j-1));
            }    
            prev = res;
            ans.add(res);
        }
        return ans;
    }
}