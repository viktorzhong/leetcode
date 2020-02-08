func change(amount int, coins []int) int {
    if len(coins) == 0 && amount != 0 {return 0}

    d := make([][]int, len(coins) + 1)
    for i,_ := range d {
        d[i] = make([]int, amount + 1)
        for j,_ := range d[i] {
            d[i][j] = -1
        }
    }

    var dfs func(idx, amount int) int 
    dfs = func(idx, amount int) int {
        if amount == 0 {return 1}
        if amount < 0 || idx >= len(coins) {return 0}

        if d[idx][amount] >= 0 {return d[idx][amount]}
        res := dfs(idx, amount - coins[idx]) + dfs(idx + 1, amount)
        d[idx][amount] = res
        return res
    }

    return dfs(0, amount)
}