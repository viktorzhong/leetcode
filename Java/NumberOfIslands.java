class Solution {
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};

    private void dfs(char[][]g, int i, int j) {
        int m = g.length, n = g[0].length;
        if(i < 0 || i >=m || j < 0 || j >= n || g[i][j] == '0') return;
        g[i][j] = '0';
        for(int k = 0; k < 4; k++) {
            dfs(g, i + dx[k], j + dy[k]);
        }
    }

    public int numIslands(char[][] g) {
        if (g == null || g.length == 0 ||
        g[0] == null || g[0].length == 0)
            return 0;

        int res = 0;
        int m = g.length, n = g[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(g[i][j] == '1') {
                    dfs(g, i, j);
                    res++;
                }
            }
        }

        return res;
    }
}