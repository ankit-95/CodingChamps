class Solution {
    public int minDeletions(String s) {
        int c[] = new int[26];
        HashSet<Integer> set = new HashSet<>();
        int ans =0;
        for(int i=0;i<s.length();i++)
            ++c[s.charAt(i)-'a'];
        for(int i=0;i<26;i++){
            while(c[i]>0 && !set.add(c[i])){
                c[i]--;
                ans++;
            }
        }
        return ans;
    }
}

