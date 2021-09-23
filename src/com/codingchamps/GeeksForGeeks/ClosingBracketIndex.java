package com.codingchamps.GeeksForGeeks;

/*Given a string with brackets ('[' and ']') and the index of an opening bracket. Find the index of the corresponding closing bracket.

        Example 1:

        Input:
        S = "[ABC[23]][89]"
        pos = 0
        Output: 8
        Explanation: [ABC[23]][89]
        The closing bracket corresponding to the
        opening bracket at index 0 is at index 8.

        â€‹Example 2:

        Input:
        S = "ABC[58]"
        pos = 3
        Output: 6
        Explanation: ABC[58]
        The closing bracket corresponding to the
        opening bracket at index 3 is at index 6.

        Expected Time Complexity: O(|S|).
        Expected Auxiliary Space: O(1).
        */
public class ClosingBracketIndex {

    public static int closing (String s, int pos)
    {
        int end = pos;
        int opencount=0;
        for(int i=pos;i<s.length();i++){
            if(s.charAt(i)=='['){
                opencount++;
            }

            if(s.charAt(i)==']'){
                if(opencount > 1){
                    opencount--;
                    continue;
                } else {
                    end = i;
                    break;
                }
            }

        }
        return end;
    }

    public static void main(String args[]){
        System.out.println(closing("[ABC[23]][89]",0));
    }
}
