func exist(board [][]byte, word string) bool {
    if len(board) == 0 || len(board[0]) == 0 {return false}
    m := len(board) 
    n := len(board[0])
    visited := make([][]bool, m)
    for i := range visited {
        visited[i] = make([]bool, n)
    }
    var dfs func(i,j,idx int) bool

    dfs = func(i, j, idx int) bool {
        if idx == len(word) {return true}
        if i < 0 || i >= len(board) || j < 0 || j >= len(board[0]) || visited[i][j] || board[i][j] != word[idx] {
               return false
        }
        visited[i][j] = true
        existed := dfs(i, j+1, idx + 1) || dfs(i, j-1, idx + 1) || dfs(i+1, j, idx + 1) || dfs(i-1, j, idx + 1)
        visited[i][j] = false
        return existed
    }

    for i := 0; i < m; i++ {
        for j := 0; j < n; j++ {
            if dfs(i, j, 0) {
                return true
            }
        }
    }
    return false
}