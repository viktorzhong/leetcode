/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func dfs(root *TreeNode, d *int) int {
    if root == nil {return 0}
    left := dfs(root.Left, d)
    right := dfs(root.Right, d)
    *d = max(*d, left + right)

    return max(left, right) + 1
}

func max(a, b int) int {
    if a > b {return a}
    return b
}

func diameterOfBinaryTree(root *TreeNode) int {
    var d int
    dfs(root, &d)
    return d
}