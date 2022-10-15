class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        String str[] = s.split(" ");
        int len = str.length;
        return str[len-1].length();
    }
}