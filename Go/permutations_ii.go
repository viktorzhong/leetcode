func permuteUnique(nums []int) [][]int {
    var res [][]int
    var backtrack func(i int)
    backtrack = func(i int) {
        if i == len(nums) {
            res = append(res, append([]int{}, nums...))
            return
        }
        freq := [20]bool{}
        for j := i; j < len(nums); j++ {
            if freq[nums[j] + 10] {continue}
            nums[i], nums[j] = nums[j], nums[i]
            backtrack(i + 1)
            nums[i], nums[j] = nums[j], nums[i]
            freq[nums[j] + 10] = true
        }
    }

    backtrack(0)
    return res
}