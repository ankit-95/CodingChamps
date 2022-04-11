class Solution {
    public int peakIndexInMountainArray(int[] ar) {
        int start = 0;
        int last = ar.length;
        while(start<last){
            int mid = (start + (last-start)/2);
            if (mid<ar.length-1 && ar[mid+1] > ar[mid]){
                start = mid+1;
            } else
                last = mid;
        }
        return start;
    }
}