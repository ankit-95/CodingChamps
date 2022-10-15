class Solution {
    public int[] asteroidCollision(int[] ar) {
        Stack<Integer> st = new Stack<>();
        for(int i : ar){
            if(i>0)
                st.push(i);
            else {
                while(!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(i)){
                    st.pop();
                }
                if(st.isEmpty() || st.peek()<0)
                    st.push(i);
                else if(i+st.peek()==0)
                    st.pop();
            }
        }
        
        int ans[] = new int[st.size()];
        for(int i=ans.length-1;i>=0;i--)
            ans[i] = st.pop();
        return ans;
    }
}