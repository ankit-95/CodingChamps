class Solution {
    public int hammingDistance(int x, int y) {
         int sum = 0;
        for(int i= 0; i < 32; i++)
        {
            if( (x & 1 ) != (y & 1) ) //  bits different so count 
                sum++;
            x = x >> 1;
            y = y >> 1;                       
        }
        return sum;     
    }
}