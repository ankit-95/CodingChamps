// class Solution {
//     public int maxProduct(String[] words) {
//         int count[] = new int[26];
//         int max = 0,i=0,j=0,k=0;
//         for(i=0;i<words.length;i++){
//             for(j=0;j<words[i].length();j++){
//                 count[words[i].charAt(j)-'a']++;
//             }
//             boolean flag = false;
//             for(k=0;k<words.length && k!=j;k++){
//                 flag = false;
//                 for(j=0;j<words[k].length();j++){
//                     if(count[words[k].charAt(j)-'a']!=0){
//                         flag = true;
//                         break;
//                     }
//                 }
//                 if(!flag){
//                     max = Math.max(max, words[i].length() *words[k].length() );
//                 }
//             }
//             Arrays.fill(count,0);
//         }
//         return max;
//     }
// }

public class Solution {
	/**
	 * @param words
	 * @return
	 * 
	 * 		The soultion is calcuated by doing a product of the length of
	 *         each string to every other string. Anyhow the constraint given is
	 *         that the two strings should not have any common character. This
	 *         is taken care by creating a unique number for every string. Image
	 *         a an 32 bit integer where 0 bit corresponds to 'a', 1st bit
	 *         corresponds to 'b' and so on.
	 * 
	 *         Thus if two strings contain the same character when we do and
	 *         "AND" the result will not be zero and we can ignore that case.
	 */
	public int maxProduct(String[] words) {
		int[] checker = new int[words.length];
		int max = 0;
		// populating the checker array with their respective numbers
		for (int i = 0; i < checker.length; i++) {
			int num = 0;
			for (int j = 0; j < words[i].length(); j++) {
				num |= 1 << (words[i].charAt(j) - 'a');
			}
			checker[i] = num;
		}

		for (int i = 0; i < words.length; i++) {
			for (int j = i + 1; j < words.length; j++) {
				if ((checker[i] & checker[j]) == 0) //checking if the two strings have common character
					max = Math.max(max, words[i].length() * words[j].length());
			}
		}
		return max;
	}

}