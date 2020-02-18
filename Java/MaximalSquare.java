class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0
            || matrix[0] == null || matrix[0].length == 0)
        return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] d = new int[m][n];
        int max = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || j == 0 || matrix[i][j] == '0') 
                    d[i][j] = matrix[i][j] == '0' ? 0 : 1;
                else 
                    d[i][j] = Math.min(d[i - 1][j - 1], Math.min(d[i - 1][j], d[i][j - 1])) + 1;
                max = Math.max(max, d[i][j]);
            }
        }
        return max * max;
    }
}