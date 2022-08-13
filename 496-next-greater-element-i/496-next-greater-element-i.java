class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s = new Stack<>();
        int res[] = new int[nums1.length];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=nums2.length-1;i>=0;i--){
            while(!s.isEmpty() && nums2[s.peek()] < nums2[i])
                s.pop();
            int ans = s.isEmpty() ? -1 : nums2[s.peek()];
            map.put(nums2[i],ans);
            s.push(i);
        }
        for(int i=0;i<nums1.length;i++){
            res[i] = map.getOrDefault(nums1[i],-1);
        }
        return res;
    }
}