class Solution {
    private final String[] mapping = new String[]{
    "abc", "def", "ghi", "jkl",
    "mno", "pqrs", "tuv", "wxyz"
    };

    private void backtrack(String digits, int idx, String cur, List<String> res) {
        if(idx == digits.length()) {
            res.add(cur);
            return;
        }
        String chars = mapping[digits.charAt(idx) - '2'];
        for(int i = 0; i < chars.length(); i++) {
            backtrack(digits, idx + 1, cur + chars.charAt(i), res);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0) return res;

        backtrack(digits, 0, "", res);
        return res;
    }
}