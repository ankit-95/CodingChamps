import java.util.Arrays;
class Solution {
    public void bubbleSort(int[] myArray) {
           int n = myArray.length;
           for (int i = 0; i < n - 1; i++) {
               for (int j = 0; j < n - i - 1; j++) {
                   if (myArray[j] < myArray[j + 1]) {
                       int temp = myArray[j];
                       myArray[j] = myArray[j + 1];
                       myArray[j + 1] = temp;
                   }
               }
           }
    }
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> people = new HashMap<>();
        for(int i=0;i<heights.length;i++){
            people.put(heights[i], names[i]);
        }
        bubbleSort(heights);
        for(int i=0;i<names.length;i++){
            names[i] = people.get(heights[i]);
        }
        return names;
    }
}