class Solution {
    public String mergeAlternately(String s1, String s2) {
        String result="";
        int i=0,j=0,k=0;
        while(i<s1.length() && j<s2.length()){
            if(k%2==0){
                result+=s1.charAt(i);
                i++;
            } else {
                result+=s2.charAt(j);
                j++;
            }
            k++;
        }
        result+= (i<s1.length())?s1.substring(i,s1.length()) : s2.substring(j,s2.length());
        return result;
    }
}