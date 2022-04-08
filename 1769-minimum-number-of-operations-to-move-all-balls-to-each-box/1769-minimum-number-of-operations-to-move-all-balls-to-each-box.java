class Solution {
    public int[] minOperations(String s) {
        int result[] = new int[s.length()];   
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                for(int j=0;j<s.length(); j++){
                    result[j] += Math.abs(i-j);
                }
            }
        }
        return result;
    }
}