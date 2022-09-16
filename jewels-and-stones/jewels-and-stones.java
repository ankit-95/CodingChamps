class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int ch[] = new int[128];
        int ans = 0;
        for(int i=0;i<stones.length();i++){
            ch[(int)stones.charAt(i)]++;
        }
        for(int i=0;i<jewels.length();i++){
            ans +=ch[(int)jewels.charAt(i)];
        }
        return ans;
    }
}