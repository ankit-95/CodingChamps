class Solution {
    
    public int search(int ar[],int start,int key){
        int i = start;
        int last = ar.length-1;
        int ans = 0;
        while(start<=last){
            int mid = (start+last)/2;
            if(ar[mid]>=key){
                start = mid+1;
            } else {
                last = mid-1;
            }
        }
        return last - i;
    }
    public int maxDistance(int[] nums1, int[] nums2) {
        int ans = 0;
        for(int i=0;i<nums1.length;i++){
            int max = search(nums2,i,nums1[i]);    
            ans = Math.max(ans,max);
        }
        return ans;
    }
}