class Solution {
    // O(s.length()) time and space.
    public int numSplits(String s) {
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> left = new HashMap<>();
        Map<Character, Integer> right = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) left.put(s.charAt(i), left.getOrDefault(s.charAt(i), 0) + 1);
        int result = 0;
        for (int i = 0; i < s.length(); ++i) {
            // Remove the current character from the left map.
            left.put(s.charAt(i), left.get(s.charAt(i)) - 1);
            if (left.get(s.charAt(i)) == 0) left.remove(s.charAt(i));
            // Add current character to the right map.
            right.put(s.charAt(i), right.getOrDefault(s.charAt(i), 0) + 1);
            if (left.size() == right.size()) result++;
        }
        return result;
    }
}