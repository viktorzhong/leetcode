func twoSum(nums []int, target int) []int {
    m := make(map[int]int, len(nums))
    
    for i, v := range nums {
        if idx, ok := m[target - v]; ok {
            return []int{idx, i}
        }
        m[v] = i
    }
    
    return []int{-1, -1}
}