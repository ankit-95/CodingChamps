class Solution {
    
    int parent[];
    int size[];
    
    public void union(int a,int b){
        a = find(a,parent);
        b = find(b,parent);
        parent[a] = b;
        size[b] += size[a];
    }
    
    public int find(int a,int parent[]){
        if(parent[a]!=a){
            parent[a] = find(parent[a],parent);
        }
        return parent[a];
    }
    
    public int getMaxComponent(){
        int max = 0;
        for(int i=0;i<parent.length;i++){
            if(i==parent[i] && size[i]>max){
                max = size[i];
            }
        }
        return max;
    }
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        parent = new int[n];
        size = new int[n];
        
        for(int i=0;i<n;i++){
           parent[i] = i;
           size[i] = 1;
        }
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])) continue;
        
            if(map.containsKey(nums[i]-1)){
                union(i,map.get(nums[i]-1));
            }
            if(map.containsKey(nums[i]+1)){
                    union(i,map.get(nums[i]+1));
            }
            map.put(nums[i],i);
        }
        
        return getMaxComponent();
    }
}