/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func dfs(root *TreeNode, sum int) int {
    if root == nil {return sum}
    cur := dfs(root.Right, sum)
    root.Val += cur
    return dfs(root.Left, root.Val)
}

func convertBST(root *TreeNode) *TreeNode {
    dfs(root, 0)
    return root
}