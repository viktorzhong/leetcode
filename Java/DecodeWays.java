class Solution {
    private boolean isValid(char a, char b) {
        return (a == '1' && b <= '9') || (a == '2' && b <= '6');
    }

    public int numDecodings(String s) {
        int[] d = new int[s.length() + 1];
        d[0] = 1;
        d[1] = s.charAt(0) == '0' ? 0 : 1;

        for(int i = 2; i <= s.length(); i++) {
            if(s.charAt(i-1) != '0') d[i] += d[i - 1];
            if(isValid(s.charAt(i - 2), s.charAt(i - 1))) d[i] += d[i - 2];
        }

        return d[s.length()];
    }
}