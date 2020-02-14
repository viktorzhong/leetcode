func uniquePaths(m int, n int) int {
    if m <= 0 || n <= 0 {return 0}
    d := make([][]int, n)
    for i,_ := range d {
        d[i] = make([]int, m)
        d[i][0] = 1
    }
    for j := 0; j < m; j++ {d[0][j] = 1}

    for i := 1; i < n; i++ {
        for j :=1; j < m; j++ {
            d[i][j] = d[i - 1][j] + d[i][j - 1]
        }
    }
    return d[n - 1][m - 1]
}