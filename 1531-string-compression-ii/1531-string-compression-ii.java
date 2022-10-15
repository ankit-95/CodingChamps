// class Solution {
//     public int getLengthOfOptimalCompression(String s, int k) {
//         int c[] = new int[26];
//         for(int i=0;i<s.length();i++){
//             c[s.charAt(i)-'a']++;
//         }
        
//         PriorityQueue<Character> q = new PriorityQueue((a,b)-> c[((char)a)-'a'] - c[((char)b)-'a']);
//         for(int i=0;i<26;i++){
//             if(c[i]!=0){
//                 q.add((char)(i+'a'));
//             }
//         }
        
//         while(k>0){
//             char ch = q.peek();
//             if(c[ch-'a'] >= k){
//                 c[ch-'a']-=k;
//                 if(c[ch-'a']==0){
//                     q.remove();
//                 }
//                 break;
//             } else {
//                k-=c[ch-'a'];
//                c[ch-'a']=0;
//                q.remove();
//             }
//         }
        
//         String str ="";
//         while(!q.isEmpty()){
//             char ch = q.remove();
//             str+=ch+""+c[ch-'a'];
//         }

//         return str.length();
//     }
// }

// class Solution {
//     Integer[][][][] dp;
//     Set<Integer> add = Set.of(1, 9, 99);
//     public int getLengthOfOptimalCompression(String s, int k) {
//         int len = s.length();
//         dp = new Integer[len + 1][27][len + 1][k + 1];
//         return dfs(s, 0, (char) ('a' + 26), 0, k);
//     }
//     // idx, current index, p, previous char, cnt, previous char count, k, num of char removable
//     private int dfs(String s, int idx, char p, int cnt, int k) {
//         if (k < 0) return Integer.MAX_VALUE;
//         if (idx >= s.length()) return 0;
//         if (dp[idx][p - 'a'][cnt][k] != null) return dp[idx][p - 'a'][cnt][k];
//         int res = 0;
//         if (s.charAt(idx) == p) res = dfs(s, idx + 1, p, cnt + 1, k) + (add.contains(cnt) ? 1 : 0);
//         else res = Math.min(dfs(s, idx + 1, s.charAt(idx), 1, k) + 1, dfs(s, idx + 1, p, cnt, k - 1));
//         dp[idx][p - 'a'][cnt][k] = res;
//         return res;
   
    
//     }
// }

class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        // dp[i][k]: the minimum length for s[:i] with at most k deletion.
        int n = s.length();
        int[][] dp = new int[110][110];
        for (int i = 0; i <= n; i++) for (int j = 0; j <= n; j++) dp[i][j] = 9999;
		// for (int[] i : dp) Arrays.fill(i, n); // this is a bit slower (100ms)
        dp[0][0] = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= k; j++) {                
                int cnt = 0, del = 0;
                for(int l = i; l >= 1; l--) { // keep s[i], concat the same, remove the different
                    if(s.charAt(l - 1) == s.charAt(i - 1)) cnt++;
                    else del++;
                    if(j - del >= 0) 
                        dp[i][j] = Math.min(dp[i][j], 
                                            dp[l-1][j-del] + 1 + (cnt >= 100 ? 3 : cnt >= 10 ? 2 : cnt >= 2 ? 1: 0));
                }
                if (j > 0) // delete s[i]
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]);
            }
        }
        return dp[n][k];
    }
}