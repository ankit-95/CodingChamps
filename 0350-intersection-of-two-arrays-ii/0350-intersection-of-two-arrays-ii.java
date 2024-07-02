class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int count[] = new int[1001];
        ArrayList<Integer> ar = new ArrayList<Integer>();
        for(int i=0;i<nums1.length;i++)
            count[nums1[i]]++;
        
        for(int i=0;i<nums2.length;i++){
            if(count[nums2[i]]>0){
                ar.add(nums2[i]);
                count[nums2[i]]--;
            }
                
        }
        return ar.stream().mapToInt(i -> i).toArray();
        
    }
}