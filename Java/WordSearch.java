class Solution {
    private boolean dfs(char[][] board, String word, int i, int j, 
                        boolean[][] visited, int idx) {
        if(idx == word.length()) return true;
        
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length 
            || visited[i][j] || board[i][j] != word.charAt(idx)) 
            return false;
        visited[i][j] = true;
        boolean existed = dfs(board, word, i + 1, j, visited, idx + 1) || 
                          dfs(board, word, i - 1, j, visited, idx + 1) || 
                          dfs(board, word, i, j + 1, visited, idx + 1) || 
                          dfs(board, word, i, j - 1, visited, idx + 1);
        visited[i][j] = false;

        return existed;
    }

    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || 
           board[0] == null || board[0].length == 0) {
                return false;
        }

        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(dfs(board, word, i, j, visited, 0)) 
                    return true;
            }
        }

        return false;
    }
}