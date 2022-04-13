class Solution {
    
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int n : arr2){
            treeSet.add(n);
        }
        int ans=0;
        for(int x : arr1){
            int l = x - d;
            int r = x + d;
            
            Set<Integer> set = treeSet.subSet(l,r+1);
            if(set.isEmpty())
                ans++;
        }
        return ans;
    }
}