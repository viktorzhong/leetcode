func minDistance(word1 string, word2 string) int {
    if len(word1) == 0 {return len(word2)}
    if len(word2) == 0 {return len(word1)}
    m := len(word1)
    n := len(word2)
    d := make([][]int, m + 1)
    for i,_ := range d {
        d[i] = make([]int, n + 1)
        d[i][0] = i;
    }
    for j := 0; j <= n; j++ {
        d[0][j] = j;
    }

    for i := 0; i < m; i++ {
        for j := 0; j < n; j++ {
            if word1[i] == word2[j] {
                d[i + 1][j + 1] = d[i][j]
            } else {
                d[i + 1][j + 1] = min(d[i + 1][j], d[i][j + 1], d[i][j]) + 1
            }
        }
    }

    return d[m][n]
}

func min(a, b, c int) int {
    if a < b && a < c {return a}
    if b < a && b < c {return b}
    return c
}