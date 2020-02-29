class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0) return;
        solve(board);
    }

    private boolean solve(char[][] board) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') {
                    for(char c = '1'; c <= '9'; c++) {
                       if(isValid(board, i, j, c)) {
                           board[i][j] = c;
                           if(solve(board)) return true;
                           board[i][j] = '.';
                       } 
                    }
                    return false;
                } 
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for(int i = 0; i < 9; i++) {
            if(board[i][col] != '.' && board[i][col] == c) return false;
            if(board[row][i] != '.' && board[row][i] == c) return false;
            int r = 3 * (row / 3) + i / 3, co = 3 * (col / 3) + i % 3;
            if(board[r][co] != '.' && board[r][co] == c) return false;
        }
        return true;
    }
}