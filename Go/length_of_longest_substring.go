func lengthOfLongestSubstring(s string) int {
    var maxLen, i, j int
    var counts [128]int

    for ; i < len(s); i++ {
        for ; j < len(s); j++ {
            if counts[s[j]] > 0 {
                break;
            }
            counts[s[j]] += 1
        }
        if j - i > maxLen {
            maxLen = j - i
        }
        counts[s[i]] -= 1
    }

    return maxLen
}