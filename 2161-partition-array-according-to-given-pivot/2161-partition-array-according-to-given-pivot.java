class Solution {
    
    public class Pair implements Comparable<Pair> {
        int index;
        int val;
        Pair(int index,int val){
            this.index = index;
            this.val = val;
        }
        
        public int compareTo(Pair p1){
            return this.index - p1.index;
        }
    }
    
    public int[] pivotArray(int[] nums, int pivot) {
            ArrayList<Pair> left = new ArrayList<>();
            ArrayList<Pair> right = new ArrayList<>();
            int count=0;
            for(int i=0;i<nums.length;i++){  
                if(nums[i]<pivot){
                    left.add(new Pair(i,nums[i]));
                }
                else if(nums[i]==pivot){
                    count++;
                }
            }
                             
            Collections.sort(left);                            
            for(int i=nums.length-1;i>=0;i--)  {
                if(nums[i]>pivot){
                    right.add(new Pair(i,nums[i]));
                }
            }
            Collections.sort(right); 
            int i = 0;
            Iterator itr = left.iterator();
            while(itr.hasNext()){
                Pair p = (Pair)itr.next();
                nums[i] = p.val;
                i++;
            }   
            while(count-->0){
                nums[i] = pivot;
                i++;
            }
            itr = right.iterator();
            while(itr.hasNext()){
                Pair p = (Pair)itr.next();
                nums[i] = p.val;
                i++;
            }  
            return nums;
        }   
}