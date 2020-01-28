
func helper(nums []int, start int, elem []int, res *[][]int) {
    temp := make([]int, len(elem))
    copy(temp, elem)
    *res = append(*res, temp)
    for i := start; i < len(nums); i += 1 {
        elem = append(elem, nums[i])
        helper(nums, i + 1, elem, res)
        elem = elem[:len(elem) - 1]
    }
}

func subsets(nums []int) [][]int {
    var res [][]int
    var elem []int
    helper(nums, 0, elem, &res)
    return res
}