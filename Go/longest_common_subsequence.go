func longestCommonSubsequence(text1 string, text2 string) int {
    if len(text1) == 0 || len(text2) == 0 {return 0}
    m := len(text1)
    n := len(text2)
    d := make([][]int, m + 1)
    for i,_ := range d {
        d[i] = make([]int, n + 1)
    }

    for i := 0; i < m; i++ {
        for j := 0; j < n; j++ {
            if text1[i] == text2[j] {
                d[i + 1][j + 1] = d[i][j] + 1
            } else {
                d[i + 1][j + 1] = max(d[i][j + 1], d[i + 1][j])
            }
        }
    }
    return d[m][n]
}

func max(a, b int ) int {
    if a > b {return a}
    return b
}