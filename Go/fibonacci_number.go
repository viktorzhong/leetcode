func fib(N int) int {
    if N <= 1 {return N}
    first := 0
    second := 1
    for i := 2; i <= N; i++ {
        first, second = second, first + second
    }
    return second
}