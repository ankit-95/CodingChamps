class Solution {
    
    public int search(int[] ar, int target) {
        int start = 0;
        int last = ar.length-1;
        while(start<=last){
            int mid = (start+last)/2;
            if(ar[mid]==target)
                return mid;
            else if(ar[mid] >= ar[start]){
                if(ar[start]<= target && target < ar[mid]){
                    last= mid -1;
                } else {
                    start = mid+1;
                }
            } else {
                if(ar[mid]<= target && target <= ar[last]){
                    start= mid +1;
                } else {
                    last = mid-1;
                }
            }
        }
        return -1;
    }
}