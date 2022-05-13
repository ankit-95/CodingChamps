class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.length()!=s2.length())
            return false;
        int s1Arr[]= new int[26];
        int s2Arr[]= new int[26];
        int count=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i))
                count++;
            if(count>2)
                return false;
            s1Arr[s1.charAt(i)-'a']++;    
            s2Arr[s2.charAt(i)-'a']++;
        }
        
        return Arrays.equals(s1Arr,s2Arr);
    }
}