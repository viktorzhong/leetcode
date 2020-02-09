class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0) return 0;
        int m = text1.length(), n = text2.length();

        int[][] d = new int[m + 1][n + 1];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                char c1 = text1.charAt(i), c2 = text2.charAt(j);
                if(c1 == c2) {
                    d[i + 1][j + 1] = d[i][j] + 1;
                } else {
                    d[i + 1][j + 1] = Math.max(d[i + 1][j], d[i][j + 1]);
                }
            }
        }
        return d[m][n];
    }
}