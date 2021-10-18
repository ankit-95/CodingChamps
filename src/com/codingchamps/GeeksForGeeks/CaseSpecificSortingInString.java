package com.codingchamps.GeeksForGeeks;


/*Case-specific Sorting of Strings
        Medium Accuracy: 57.47% Submissions: 15067 Points: 4
        Given a string S consisting of uppercase and lowercase characters. The task is to sort uppercase and lowercase letters separately such that if the ith place in the original string had an Uppercase character then it should not have a lowercase character after being sorted and vice versa.

        Example 1:

        Input:
        N = 12
        S = defRTSersUXI
        Output: deeIRSfrsTUX
        Explanation: Sorted form of given string
        with the same case of character as that
        in original string is deeIRSfrsTUX

        Your Task:
        You only need to complete the function caseSort that returns sorted string.

        Expected Time Complexity: O(N*Log(N)).
        Expected Auxiliary Space: O(N).*/
public class CaseSpecificSortingInString {

    public static String buildHeap(char[] c) {

        for (int i = (c.length - 1) / 2; i >= 0; i--) {
            heapify(c, c.length, i);
        }
        String result = "";
        for (int i = c.length - 1; i >= 0; i--) {
            result += String.valueOf(c[0]);
            char temp = c[0];
            c[0] = c[i];
            c[i] = temp;

            heapify(c, i, 0);
        }

        return result;
    }

    public static void heapify(char c[], int n, int i) {

        int smallest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && (int) c[l] < (int) c[smallest])
            smallest = l;
        if (r < n && (int) c[r] < (int) c[smallest])
            smallest = r;

        if (smallest != i) {
            char temp = c[smallest];
            c[smallest] = c[i];
            c[i] = temp;
            heapify(c, n, smallest);
        }
    }

    //Function to perform case-specific sorting of strings.
    public static String caseSort(String a) {
        char ch[] = a.toCharArray();

        String sortedStr = buildHeap(ch);
        char copy[] = a.toCharArray();

        int index = 0;
        for (int i = 0; i < copy.length; i++) {

            if (copy[i] >= 'A' && copy[i] <= 'Z')
                copy[i] = sortedStr.charAt(index++);
        }
        for (int i = 0; i < copy.length; i++) {

            if (copy[i] >= 'a' && copy[i] <= 'z')
                copy[i] = sortedStr.charAt(index++);
        }

        return new String(copy);
    }

    public static void main(String args[]) {

        System.out.println(caseSort("defRTSersUXI"));
    }

}
