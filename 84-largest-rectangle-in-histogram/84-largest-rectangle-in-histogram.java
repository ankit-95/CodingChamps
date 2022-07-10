class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> s = new Stack<>();
        int maxi = 0;
        for(int i=0;i<=heights.length;i++){
            int val = i==heights.length ? -1 : heights[i];
            while(!s.isEmpty() && val <= heights[s.peek()]){
                int h = heights[s.pop()];
                int w = s.isEmpty() ? i : i-s.peek()-1;
                maxi = Math.max(maxi,h*w);
            } 
           s.push(i);
        }
        return maxi;
    }
}