func numSquares(n int) int {
    d := make([]int, n + 1)
    d[0] = 0
    for i := 1; i <= n; i++ {
        d[i] = i
        for j := 1; j*j <= i; j++ {
            d[i] = min(d[i], d[i - j * j] + 1)
        }
    }
    return d[n]
}

func min(a, b int) int {
    if a < b {return a}
    return b
}