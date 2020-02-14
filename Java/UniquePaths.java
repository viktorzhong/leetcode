class Solution {
    public int uniquePaths(int m, int n) {
        if(m <= 0 || n <= 0) return 0;
        int[][] d = new int[n][m];
        for(int i = 0; i <n; i++) d[i][0] = 1;
        for(int j = 0; j <m; j++) d[0][j] = 1;

        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                d[i][j] = d[i - 1][j] + d[i][j - 1];
            }
        }

        return d[n - 1][m - 1];
    }
}