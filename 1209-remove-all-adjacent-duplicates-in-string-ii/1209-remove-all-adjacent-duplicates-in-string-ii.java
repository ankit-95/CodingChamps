// class Solution {
//     public String removeDuplicates(String s, int k) {
//         Stack<Character> s1 = new Stack<>();
//         for(int i=0;i<s.length();i++){
//             if(!s1.isEmpty() && s.charAt(i)==s1.peek()){
//                 int t = k-1;
//                 while(!s1.isEmpty() && t>0 && s1.peek()==s.charAt(i)){
//                     t--;
//                     s1.pop();
//                 }
//             }
//             else {
//                 s1.push(s.charAt(i));
//             }
//         }
//         StringBuilder sb = new StringBuilder();
//         Iterator itr = s1.iterator();
//         while(itr.hasNext()){
//             sb.append(itr.next());
//         }
//         return sb.toString();
//     }
// }

class Solution {
    public String removeDuplicates(String s, int k) {
        // ArrayDeque has better performance than Stack and LinkedList
        ArrayDeque<Adjacent> st = new ArrayDeque<>(s.length());
        for (char c : s.toCharArray()) {
            if (!st.isEmpty() && st.peekLast().ch == c) {
                st.peekLast().freq++; // Increase the frequency
            } else {
                st.addLast(new Adjacent(c, 1));
            }
            if (st.peekLast().freq == k) // If reach enough k duplicate letters -> then remove
                st.removeLast();
        }
        StringBuilder sb = new StringBuilder();
        for (Adjacent a : st) {
            sb.append(String.valueOf(a.ch).repeat(a.freq));
        }
        return sb.toString();
    }
    class Adjacent {
        char ch;
        int freq;
        public Adjacent(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }
}