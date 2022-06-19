class Solution {
    
    public int binarySearch(int nums[],int target){
        int start =0;
        int last = nums.length-1;
        while(start<=last){
            int mid = (start+last)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]<target)
                start++;
            else last--;
        }
        return -1;
    }
    
    public int[] intersection(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        ArrayList<Integer> result = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        if(len1<len2){
            for(int i=0;i<len1;i++){
                int ans =  binarySearch(nums2,nums1[i]);
                if(ans!=-1){
                    if(result.isEmpty() || (!result.isEmpty() && result.get(result.size()-1)!=nums2[ans]))
                        result.add(nums2[ans]);
                }
            }
        } else {
            for(int i=0;i<len2;i++){
                int ans =  binarySearch(nums1,nums2[i]);
                if(ans!=-1){
                    if(result.isEmpty() || (!result.isEmpty() && result.get(result.size()-1)!=nums1[ans]))
                        result.add(nums1[ans]);
                }
            }
        }
        int resultArr[] = new int[result.size()];
        int count=0;
        for(int i : result){
            resultArr[count++] = i;
        }
        return resultArr;
    }
}