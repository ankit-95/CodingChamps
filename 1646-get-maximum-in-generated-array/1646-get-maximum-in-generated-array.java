class Solution {
    public void helper(int n, List<Integer> list,int index,int ans[]){
        if(index==n)
            return;
        if(index%2==0){
            ans[0] = Math.max(ans[0],list.get(index/2));
            list.add(list.get(index/2));
            
        }
        if(index%2!=0){
            ans[0] = Math.max(ans[0],list.get(index/2 + 1) + list.get(index/2));
            list.add(list.get(index/2 + 1) + list.get(index/2));
        }
        helper(n,list,index+1,ans);
    }
    public int getMaximumGenerated(int n) {
         if(n<=1)
             return n;
         List<Integer> list = new ArrayList<>();
         list.add(0);
         list.add(1);
         int ans[] = new int[1];
         ans[0] = Integer.MIN_VALUE;
         helper(n+1,list,2,ans);
         //System.out.print(list);
         return ans[0];
    }
}