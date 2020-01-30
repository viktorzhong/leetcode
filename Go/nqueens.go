func solveNQueens(n int) [][]string {
    var res [][]string
    if  n <= 0 {return res}

    cols := make(map[int]int, n)
    diff := make(map[int]int, n)
    sum := make(map[int]int, n)
    board := make([][]rune, n)
	for i := 0; i < n; i++ {
		item := make([]rune, n)
		for j := 0; j < n; j++ {
			item[j] = '.'
		}
		board[i] = item
	}

    var dfs func(row int)
    dfs = func(row int) {
        if row == n {
            var tmp []string
            for _, v := range board {
                tmp = append(tmp, string(v))
            }
            res = append(res, tmp)
            return;
        }
        for col := 0; col < n; col++ {
            if cols[col] == 0 && diff[col - row] == 0 && sum[col + row] == 0 {
                cols[col] = 1
                diff[col - row] = 1
                sum[col + row] = 1
                board[row][col] = 'Q'
                dfs(row + 1)
                cols[col] = 0
                diff[col - row] = 0
                sum[col + row] = 0
                board[row][col] = '.'
            }
        }
    }
    
    dfs(0)
    return res
}