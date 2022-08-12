class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0,j=0;
        HashSet<Character> set = new HashSet<>();
        int max=0;
        while(j<s.length()){
            if(!set.contains(s.charAt(j))){
                max = Math.max(max,j-i+1);
                set.add(s.charAt(j++));
            }
            else{
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }
}