/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func maxPathSum(root *TreeNode) int {
    ret := math.MinInt32
    dfs(root, &ret)
    return ret
}

func dfs(root *TreeNode, ret *int) int {
    if root == nil {return 0}

    left := max(dfs(root.Left, ret), 0)
    right := max(dfs(root.Right, ret), 0)
    cur := root.Val + left + right
    *ret = max(*ret, cur)

    return root.Val + max(left, right)
}

func max(a, b int) int {
    if a > b { return a }
    return b
}