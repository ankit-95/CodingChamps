class Solution {
    public int[] findOriginalArray(int[] changed) {
        if(changed.length%2==1)
            return new int[0];
        
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();
        Arrays.sort(changed);
        for(int i=0;i<changed.length;i++){
            map.put(changed[i], map.getOrDefault(changed[i],0)+1);
        }
        
        int original[] = new int[changed.length/2];
        int index=0;
        for(int num : changed){
            if(map.get(num)>0){
                map.put(num,map.get(num)-1);
                int twice = 2 * num;
                if(map.containsKey(twice) && map.get(twice)>0){
                    map.put(twice, map.get(twice)-1);
                    original[index++]= num;
                }
                else{
                   return new int[0]; 
                }
            }
        }
        return original;
    }
}