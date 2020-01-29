func combinationSum(candidates []int, target int) [][]int {
    var res [][]int
    var backtrack func(cur, start int, elem []int)
    backtrack = func(cur, start int, elem []int) {
        if cur == 0 {
            res = append(res, append([]int{}, elem...))
            return
        }
        if cur < 0 {return}
        for i := start; i < len(candidates); i++ {
            elem = append(elem, candidates[i])
            backtrack(cur - candidates[i], i, elem)
            elem = elem[:len(elem) - 1]
        }
    }
    backtrack(target, 0, []int{})
    return res
}