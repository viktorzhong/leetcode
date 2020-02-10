func maxSubArray(nums []int) int {
    if len(nums) == 0 {return 0}
    d := make([]int, len(nums))
    d[0] = nums[0]
    res := d[0]

    for i := 1; i < len(nums); i++ {
        d[i] = max(d[i - 1] + nums[i], nums[i])
        res = max(res, d[i])
    }

    return res
}

func max(a, b int) int {
    if a > b {return a}
    return b
}