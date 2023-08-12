import java.util.*;
class Solution {
    public String getHint(String secret, String guess) {

        HashMap<Character,Integer> map = new HashMap<>();
         int bull=0;
        int cow=0;
        for(int i=0;i<guess.length();i++){
            if(secret.charAt(i)==guess.charAt(i)){
                bull++;
            }
            else{
                map.put(guess.charAt(i),map.getOrDefault(guess.charAt(i),0)+1);
            }
            
        }
       

        for(int i=0;i<secret.length();i++){
            
            if(map.containsKey(secret.charAt(i)) && secret.charAt(i)!=guess.charAt(i) && map.get(secret.charAt(i))>0){
                  
                 cow++;
                  map.put(secret.charAt(i),map.get(secret.charAt(i))-1);
                  
                  
            }
            else if(!map.containsKey(secret.charAt(i))){
                continue;
            }
        }
        String ans = Integer.toString(bull) + "A"+ Integer.toString(cow) +"B";
        return ans;
        
    }
}