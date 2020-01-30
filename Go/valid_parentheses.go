func isValid(s string) bool {
    stack := []rune{}
    m := map[rune]rune {
        '(': ')',
		'{': '}',
		'[': ']',
    }
    
    for _, v := range s {
        if v == '(' || v == '[' || v == '{' {
            stack = append(stack, m[v])
        } else {
            if len(stack) == 0 || stack[len(stack) - 1] != v {return false}
            stack = stack[:len(stack) - 1]
        }
    }

    return len(stack) == 0
}