func numIslands(g [][]byte) int {
    var res int
    if len(g) == 0 || len(g[0]) == 0 {
        return res
    }
    m, n := len(g), len(g[0])
    dx := [4]int{0, 0 , 1, -1}
    dy := [4]int{1, -1, 0, 0}

    var dfs func(i, j int) 
    dfs = func(i, j int) {
        if i < 0 || j < 0 || i >= m || j >= n || g[i][j] == '0' {return}
        g[i][j] = '0'
        for k := 0; k < 4; k++ {
            dfs(i + dx[k], j + dy[k])
        }
    }

    for i := 0; i < m; i++ {
        for j := 0; j < n; j++ {
            if g[i][j] == '1' {
                dfs(i, j)
                res++
            }
        }
    }

    return res
}