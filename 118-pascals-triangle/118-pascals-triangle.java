class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur,prev = null;
        for(int i=0;i<numRows;i++){
            cur = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    cur.add(1);
                } else {
                    cur.add(prev.get(j)+prev.get(j-1));
                }
            }
            prev = cur;
            ans.add(new ArrayList<>(cur));
        }
        return ans;
    }
}