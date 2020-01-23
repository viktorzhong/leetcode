func generate(res *[]string, s []byte, left, right int) {
    if left == 0 && right == 0 {
        *res = append(*res, string(s))
    }
    if left > 0 {
        generate(res, append(s, '('), left - 1, right)
    }
    if right > left {
        generate(res, append(s, ')'), left, right - 1)
    }
}

func generateParenthesis(n int) []string {
    res := make([]string, 0)
    var s []byte
    generate(&res, s, n, n)

    return res
}