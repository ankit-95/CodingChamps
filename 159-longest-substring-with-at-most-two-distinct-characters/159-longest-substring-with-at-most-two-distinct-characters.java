class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character,Integer> count = new HashMap<>();
        int start =0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i),0)+1);
            while(count.size()>2){
                count.put(s.charAt(start), count.getOrDefault(s.charAt(start),0)-1);  
                if(count.get(s.charAt(start))==0)
                    count.remove(s.charAt(start));
                start++;
            }
            max = Math.max(max, i - start +1);
        }
        return max;
    }
}