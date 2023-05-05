class Solution {
    public int maxVowels(String s, int k) {
        int max = Integer.MIN_VALUE;
        int current = 0;
        for(int i=0;i<k;i++){
            if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u'){
                current+=1;
            }
        }
        
        max = Math.max(max,current);
        for(int i=k;i<s.length();i++){
            if(s.charAt(i-k)=='a' || s.charAt(i-k)=='e' || s.charAt(i-k)=='i' || s.charAt(i-k)=='o' || s.charAt(i-k)=='u'){
                current-=1;
            }
            
            if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u'){
                current+=1;
            }
            
            
            max = Math.max(max,current);
        }
        
        return max;
    }
}