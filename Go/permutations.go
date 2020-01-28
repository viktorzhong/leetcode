func permute(nums []int) [][]int {
    var res [][]int
    var backtrack func(i int)
    backtrack = func(i int) {
        if i == len(nums) {
            res = append(res, append([]int{}, nums...))
            return
        }
        for j := i; j < len(nums); j++ {
            nums[i], nums[j] = nums[j], nums[i]
            backtrack(i + 1)
            nums[i], nums[j] = nums[j], nums[i]
        }
    }

    backtrack(0)
    return res
}