func letterCombinations(digits string) []string {
    if len(digits) == 0 {
        return nil
    }
    var backtrack func(idx int, cur string)
    var res []string
    keys := make(map[byte][]byte, 8)
    keys['2'] = []byte{'a', 'b', 'c'}
    keys['3'] = []byte{'d','e','f'}
    keys['4'] = []byte{'g','h','i'}
    keys['5'] = []byte{'j','k','l'}
    keys['6'] = []byte{'m','n','o'}
    keys['7'] = []byte{'p','q','r','s'}
    keys['8'] = []byte{'t','u','v'}
    keys['9'] = []byte{'w','x','y','z'}

    backtrack = func(idx int, cur string) {
        if idx == len(digits) {
            res = append(res, cur)
            return
        }
        for _, v := range keys[digits[idx]] {
            backtrack(idx + 1, cur + string(v))
        }
    }
    backtrack(0, "")

    return res
}