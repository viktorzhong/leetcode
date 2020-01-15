func isHappy(n int) bool {
    if n <= 0 {
        return false
    }

    used := make(map[int]bool)
    used[n] = true

    curr := n

    for curr != 1 {
        newN := 0
        for ; curr > 0; curr /= 10 {
            r := curr % 10
            newN += r * r
        }
        curr = newN
        if used[curr] {return false}
        used[curr] = true
    }

    return true
}