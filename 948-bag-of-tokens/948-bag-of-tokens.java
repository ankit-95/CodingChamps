class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score = 0;
        int l = 0;
        int r = tokens.length-1;
        int ans =0;
        while(l<=r && (power >=tokens[l] || score>0)){
            while(l<=r && tokens[l]<=power){
                power-=tokens[l++];
                score++;
            } 
            ans = Math.max(ans,score);
            if(l<=r && score>0){
               power+=tokens[r--];
               score--; 
            }
        }
        return ans;
    }
}