class Solution {

    private int[] dx = new int[]{1, -1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};

    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        int freshCount = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) 
                    q.offer(new int[]{i, j});
                else if(grid[i][j] == 1)
                    ++freshCount;
            }
        }

        int level = 0;
        while(!q.isEmpty() && freshCount > 0) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] d = q.poll();
                for(int k = 0; k < 4; k++) {
                    int r = d[0] + dx[k], c = d[1] + dy[k];
                    if(r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        freshCount--;
                        q.offer(new int[]{r, c});
                    }
                }
            }
            ++level;
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1)
                    return -1; 
            }
        }

        return level;
    }
}