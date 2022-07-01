class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b)-> b[1]-a[1]);
        for(int a[] : boxTypes){
            System.out.println(a[0]+" "+a[1]);
        }
        int profit=0;
        for(int i=0;i<boxTypes.length;i++){
            if(truckSize>=0){
                int len = 1;
                if(truckSize>=boxTypes[i][0]){
                    len = boxTypes[i][0];
                } else {
                    len = truckSize;
                }
                truckSize -= len;
                profit+= len*boxTypes[i][1];
            }
        }
        return profit;
    }
}