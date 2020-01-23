func climbStairs(n int) int {
    if n < 3 {return n}
    n1, n2 := 1, 1

    for i := 3; i <= n; i++ {
        n3 := n1 + n2
        n1, n2 = n2, n3
    }
    return n1 + n2
}