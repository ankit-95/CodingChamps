import java.util.*;
class Solution {
    public int characterReplacement(String s, int k) {
        int freq[] = new int[26];
        int left = 0;
        int mostfrq = 0;
        int max = 0;
        for(int right=0;right<s.length();right++){
            freq[s.charAt(right)-'A']++;
            mostfrq = Math.max(mostfrq,freq[s.charAt(right)-'A']);
            
            int letterToChange = (right - left + 1) - mostfrq;
            if(letterToChange>k){
                freq[s.charAt(left)-'A']--;
                left++;
            }
            
            max = Math.max(max, right - left +1);
        }
        return max;
    }
}