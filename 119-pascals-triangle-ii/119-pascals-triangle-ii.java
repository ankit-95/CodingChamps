class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res=null,prev=null;
        for(int i=0;i<rowIndex+1;i++){
            res =  new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0||j==i)
                    res.add(1);
                else
                    res.add(prev.get(j-1)+prev.get(j));
            }
            prev = res;
        }
        return res;
    }
}