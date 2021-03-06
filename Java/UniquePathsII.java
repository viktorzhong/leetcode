class Solution {
    public int uniquePathsWithObstacles(int[][] obstacle) {
        if(obstacle == null || obstacle[0] == null) return 0;
        int n = obstacle.length, m = obstacle[0].length;
        int[][] d = new int[n][m];
        for(int i = 0; i <n; i++) {
            if(obstacle[i][0] == 1) {
                for(int k = i; k < n; k++) d[k][0] = 0;
                break;
            } else {
                d[i][0] = 1;
            }
        } 
        for(int j = 0; j <m; j++) {
            if(obstacle[0][j] == 1) {
                for(int k = j; k < m; k++) d[0][k] = 0;
                break;
            } else {
                d[0][j] = 1;
            }
        }

        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                if(obstacle[i][j] == 1) d[i][j] = 0;
                else  d[i][j] = d[i - 1][j] + d[i][j - 1];
            }
        }

        return d[n - 1][m - 1];
    }
}