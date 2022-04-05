class Solution {
    public String reverseWords(String s) {
        String[] s1 = s.split("\\s");
        s = new String("");
        for(int i=0;i<s1.length-1;i++){
            StringBuilder sb = new StringBuilder();
            sb.append(s1[i]);
            sb.reverse();
            s+=sb.toString();
            s+=" ";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s1[s1.length-1]);
        sb.reverse();
        s+=sb.toString();
        return s;
    }
}