class Solution {
    private int max = 0;
    public int maxLength(List<String> arr) {
        dfs(arr, 0, "");
        return max;
    }

    public void dfs(List<String> arr, int index, String concatenatStr) {
        if (isUnique(concatenatStr)) max = Math.max(max, concatenatStr.length());
        if (index == arr.size() || !isUnique(concatenatStr))  return;
        for (int i = index; i < arr.size(); i++) {
            dfs(arr, i + 1, concatenatStr + arr.get(i));
        }
    }
    public boolean isUnique(String s) {
        int[] alpha = new int[26];
        for (int i = 0; i < s.length(); i++) alpha[s.charAt(i) - 'a']++;
        for (int i = 0; i < alpha.length; i++) if (alpha[i] > 1) return false;
        return true;
    }
}