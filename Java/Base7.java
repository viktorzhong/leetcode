class Solution {
    public String convertToBase7(int num) {
        if(num == 0) return "0";
        boolean isNegetive = num < 0;
        num = Math.abs(num);
        StringBuilder res = new StringBuilder();
        int r = 0;
        while(num > 0) {
            r = num % 7;
            num /= 7;
            res.append(String.valueOf(r));
        }
        if(isNegetive) res.append("-");
        return res.reverse().toString();
    }
}