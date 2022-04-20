class Solution {
    public int findKthPositive(int[] arr, int k) {
        int start=0;
        int last = arr.length;
        while(start<last){
            int mid = (start+last)/2;
            if(arr[mid]-mid-1<k){
                start = mid+1;
            } else 
                last=mid;
        }
        return start+k;
    }
}