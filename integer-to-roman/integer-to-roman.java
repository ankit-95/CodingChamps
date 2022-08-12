class Solution {
    static int ar[] = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
    public static int findLastGreater(int ar[],int num){
        int start = 0;
        int last = ar.length-1;
        int ans = -1;
        while(start<=last){
            int mid = (start+last)/2;
            if(ar[mid] > num )
                last = mid -1;
            else {
                ans = mid;
                start = mid+1;
            }
        }
        return ans;
    }
    static HashMap<Integer, String> map = new HashMap<>();
    static {
        map.put(1,"I");
        map.put(4,"IV");
        map.put(5,"V");
        map.put(9,"IX");
        map.put(10,"X");
        map.put(40,"XL");
        map.put(50,"L");
        map.put(90,"XC");
        map.put(100,"C");
        map.put(400,"CD");
        map.put(500,"D");
        map.put(900,"CM");
        map.put(1000,"M");
    }
    public String intToRoman(int num) {
        String result="";
        while(num>0){
        int index = findLastGreater(ar,num);
        result+=map.get(ar[index]);
        num -= ar[index];
      }
        return result;
    }
}