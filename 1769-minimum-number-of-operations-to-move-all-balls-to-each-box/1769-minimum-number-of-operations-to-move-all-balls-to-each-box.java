class Solution {
    public int[] minOperations(String s) {
        int result[] = new int[s.length()];   
        int ops=0;
        int cnt=0;
        for(int i=0;i<s.length();i++){
            result[i]+=ops;
            cnt+= (int)(s.charAt(i) - '0');
            ops+= cnt;
        }
        ops=0;cnt=0;
        for(int i=s.length()-1;i>=0;i--){
            result[i]+=ops;
            cnt+= (int)(s.charAt(i) - '0');
            ops+= cnt;
        }
        return result;
        
    }
}