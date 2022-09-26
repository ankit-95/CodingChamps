class Solution {
    
    public static int merge(int ar[],int p,int mid,int r){
        int n1 = mid - p +1;
        int n2 = r-mid;
        int left[] = new int[n1];
        int right[] = new int[n2];
        
        for(int i=0;i<n1;i++)
            left[i] = ar[p+i];
        for(int i=0;i<n2;i++)
            right[i] = ar[mid+1+i];
          
        int cnt = 0;
        int t1 = 0; 
        for(int i = 0;i<n1;i++) {
            while(t1<n2 && left[i] > (2 * (long) right[t1])) {
                t1++;
            }
            cnt += t1;
        }
        
        int i=0,j=0,k=p;
        while(i<n1 && j<n2){
            if(left[i] < right[j])
                ar[k++] = left[i++];
            else{
                ar[k++] = right[j++];
            }     
        }
        
        while(i<n1)
            ar[k++] = left[i++];
        while(j<n2)
            ar[k++] = right[j++];
            
        return cnt;    
            
    }
    
    public static int mergeSort(int ar[],int p,int r){
        if(p>=r) return 0;
        int mid = (p+r)/2;
        int count =mergeSort(ar,p,mid);
        count+=mergeSort(ar,mid+1,r);
        count+=merge(ar,p,mid,r);
        return count;
    }
    
    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }
}