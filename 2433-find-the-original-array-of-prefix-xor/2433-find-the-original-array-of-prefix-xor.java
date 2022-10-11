class Solution {
    public int[] findArray(int[] pref) {
        int ans[] = new int[pref.length];
        
        for(int i=pref.length-1;i>0;i--){
            ans[i] = pref[i] ^ pref[i-1];
        }
        ans[0] = pref[0];
        return ans;
    }
}