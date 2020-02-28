class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> rows = new HashSet<>();
        Set<Character> cols = new HashSet<>();
        Set<Character> cube = new HashSet<>();
        for(int i = 0; i < 9; i++) {
            rows.clear(); cols.clear(); cube.clear();
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.' && !rows.add(board[i][j])) return false;
                if(board[j][i] != '.' && !cols.add(board[j][i])) return false;
                int r = 3 * (i / 3) + j / 3, c = 3 * (i % 3) + j % 3;
                if(board[r][c] != '.' && !cube.add(board[r][c])) return false;
            }
        }
        return true;
    }
}