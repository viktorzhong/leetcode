func singleNumber(nums []int) int {
    var sum int

    for _, v := range nums {
        sum ^= v
    }

    return sum
}