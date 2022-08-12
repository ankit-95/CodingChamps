class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int start = 0;
        int last = height.length-1;
        while(start<=last){
            max = Math.max(max,((last-start)*Math.min(height[start],height[last])));
            if(height[start] < height[last])
                start++;
            else if(height[start] > height[last])
                last--;
            else {
                start++;
                last--;
            }
        }
        return max;
    }
}