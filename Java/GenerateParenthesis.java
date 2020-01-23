class Solution {

    List<String> res = new ArrayList<>();

    private void generate(String s, int left, int right) {
        if(left == 0 && right == 0) res.add(s);
        if(left > 0) generate(s + "(", left - 1, right);
        if(right > left) generate(s + ")", left, right - 1);
    }

    public List<String> generateParenthesis(int n) {
        generate("", n, n);
        return res;
    }
}