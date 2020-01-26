func abs(n int64) int64 {
    if n < 0 {return n * -1}
    return n
}

func myPow(x float64, n int) float64 {
    N := int64(n)
    res := 1.0
    N = abs(N)

    for N > 0 {
        if (N & 1) == 1 {res *= x}
        x *= x
        N >>= 1
    }
    if(n < 0) {return 1 / res}
    return res
}