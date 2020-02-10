func maxProfit(prices []int) int {
    if len(prices) < 2 {return 0}
    profit := 0
    buy := prices[0]

    for i := 1; i < len(prices); i++ {
        if prices[i] < buy {
            buy = prices[i]
        } else {
            profit = max(profit, prices[i] - buy)
        }
    }
    return profit
}

func max(a, b int) int {
    if a > b {return a}
    return b
}