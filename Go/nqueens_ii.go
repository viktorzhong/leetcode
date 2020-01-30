func totalNQueens(n int) int {
    res := 0
    if  n <= 0 {return res}

    cols := make(map[int]int, n)
    diff := make(map[int]int, n)
    sum := make(map[int]int, n)

    var dfs func(row int)
    dfs = func(row int) {
        if row == n {
            res++;
            return;
        }
        for col := 0; col < n; col++ {
            if cols[col] == 0 && diff[col - row] == 0 && sum[col + row] == 0 {
                cols[col] = 1
                diff[col - row] = 1
                sum[col + row] = 1
                dfs(row + 1)
                cols[col] = 0
                diff[col - row] = 0
                sum[col + row] = 0
            }
        }
    }
    
    dfs(0)
    return res
}