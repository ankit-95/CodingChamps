/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int start = 0;
        int last = n;
        while(start<last){
            int mid = (start+(last-start)/2);
            if(0==guess(mid))
                return mid;
            else if(guess(mid) ==1){
                start = mid+1;
            }
            else {
                last = mid;
            }
        }
        return start;
    }
}