class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        int b1[] = new int[256];
        int b2[] = new int[256];
        Arrays.fill(b1,-1);
        Arrays.fill(b2,-1);
        
        for(int i=0;i<s.length();i++){
            int c1 = s.charAt(i);
            int c2 = t.charAt(i);
            
            if(b1[c1]==-1 && b2[c2]==-1){
                b1[c1] = c2;
                b2[c2] = c1;
                
            } else if(!(b1[c1]==c2 && b2[c2]==c1))
                return false;
        }
        return true;
    }
}