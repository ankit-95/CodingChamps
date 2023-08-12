class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        String rev = "";
        for(int i=n-1;i>=0;i--){
            rev+=s.charAt(i);    
        }
        String s_new = s + "#" + rev;
        int n_new = s_new.length();
        int f[] = new int[n_new];
        for (int i = 1; i < n_new; i++) {
            int t = f[i - 1];
            while (t > 0 && s_new.charAt(i) != s_new.charAt(t)) {
                t = f[t - 1];
            }
            if (s_new.charAt(i) == s_new.charAt(t)) {
                ++t;
            }
            f[i] = t;
        }
        return rev.substring(0, n - f[n_new - 1]) + s;
    }
}