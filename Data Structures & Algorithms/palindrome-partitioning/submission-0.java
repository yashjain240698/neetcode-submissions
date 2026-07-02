class Solution {
    List<List<String>> ans = new ArrayList<>();
    private boolean isPalindrome(String str) {
        int l = 0, r = str.length() - 1;
        while (l <= r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    private void helper(String str, List<String> l, int idx) {
        if (idx >= str.length()) {
            ans.add(new ArrayList<>(l));
            return;
        }
        String temp;
        for (int i = idx; i < str.length(); i++) {
            temp = str.substring(idx, i + 1);

            if (isPalindrome(temp)) {
                l.add(temp);
                helper(str, l, i + 1);
                l.remove(l.size() - 1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        helper(s, new ArrayList<>(), 0);
        return ans;
    }
}
