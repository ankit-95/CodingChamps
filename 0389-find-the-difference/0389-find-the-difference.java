class Solution {
    public char findTheDifference(String s, String t) {
        int xor=0;
        int i =0;
        for(i=0;i<s.length();i++)
            xor ^= (int)s.charAt(i) ^ (int)t.charAt(i);
        xor^= t.charAt(i);
        return (char)xor;
    }
}