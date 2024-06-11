class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer,Integer> freq = new TreeMap<>();
        for(int i: arr1){
            if(freq.containsKey(i)){
               freq.put(i, freq.get(i)+1);
            } else {
               freq.put(i,1);
            }
        }
        System.out.println(freq);
        int index = 0;
        for(int i: arr2){
            if(freq.containsKey(i)){
                while(freq.get(i)>0){
                    arr1[index++] = i;
                    freq.put(i, freq.get(i)-1);
                }
                freq.put(i, -1);
            }
        }
        System.out.println(freq);
        for(Map.Entry<Integer,Integer> pair: freq.entrySet()){
            if(pair.getValue()!=-1){
                int f = pair.getValue();
                while(f>0){
                    arr1[index++] = pair.getKey();
                    f--;
                }
            }
        }
        return arr1;
    }
}