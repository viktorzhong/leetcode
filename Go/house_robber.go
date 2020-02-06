	func rob(nums []int) int {
    var res int
    cache := make([]int, len(nums))
    for i,_ := range cache {
        cache[i] = -1
    }
    if len(nums) == 0 {return 0}

    var solve func(idx int) int
    solve = func(idx int) int {
        if idx >= len(nums) {return 0}
        if cache[idx] >= 0 {return cache[idx]}

        ret := max(nums[idx] + solve(idx + 2), solve(idx + 1))
        cache[idx] = ret
        return ret
    }
    res = solve(0)
    return res
}

func max(a, b int) int {
    if a > b {return a}
    return b
}