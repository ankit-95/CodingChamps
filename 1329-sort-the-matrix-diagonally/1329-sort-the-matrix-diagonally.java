class Solution {
    public int[][] diagonalSort(int[][] mat) {
        Map<Integer,PriorityQueue<Integer>> map = new HashMap<>();
        int n = mat.length;
        for(int i=0;i<mat.length;i++){
             for(int j=0;j<mat[0].length;j++){
                map.putIfAbsent(n-1+j-i, new PriorityQueue<>());
                map.get(n-1+j-i).add(mat[i][j]);
            }
        }
        
        for(int i=0;i<mat.length;i++){
             for(int j=0;j<mat[0].length;j++){
                mat[i][j] = map.get(n-1+j-i).remove();
            }
        }
        return mat;
    }
}