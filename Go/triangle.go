func minimumTotal(triangle [][]int) int {
    if len(triangle) == 0 {return 0}
    rows := len(triangle)
    d := make([]int, rows + 1)

    for i := rows - 1; i >= 0; i-- {
        for j := 0; j <= i; j++ {
            d[j] = min(d[j], d[j + 1]) + triangle[i][j]
        }
    }
    return d[0]
}

func min(a, b int) int {
    if a < b {return a}
    return b
}