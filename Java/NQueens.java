class Solution {

    private Set<Integer> cols = new HashSet<>();
    private Set<Integer> diff = new HashSet<>();
    private Set<Integer> sum = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if(n <= 0) return res;

        char[][] board = new char[n][n];
        initBoard(board, n);

        dfs(n, 0, board, res);

        return res;
    }

    private void dfs(int n, int row, char[][]board, List<List<String>> res) {
        if(row == n) {
            List<String> tmp = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                tmp.add(String.valueOf(board[i]));
            }
            res.add(tmp);
            return;
        }

        for(int col = 0; col < n; col++) {
            if(!cols.contains(col) && !diff.contains(col - row) && !sum.contains(col + row)) {
                cols.add(col); diff.add(col - row); sum.add(col + row);
                board[row][col] = 'Q';
                dfs(n, row + 1, board, res);
                cols.remove(col); diff.remove(col - row); sum.remove(col + row);
                board[row][col] = '.';
            }
        }

    }

    private void initBoard(char[][] board, int n) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
    }
}