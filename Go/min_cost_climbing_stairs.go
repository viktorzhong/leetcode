func minCostClimbingStairs(cost []int) int {
    if len(cost) == 0 {return 0}
    if len(cost) == 1 {return cost[0]}
    a, b := cost[0], cost[1]
    for i := 2; i < len(cost); i++ {
        a, b = b, min(a, b) + cost[i]
    }
    return min(a, b)
}

func min(a, b int) int {
    if a < b {return a}
    return b
}