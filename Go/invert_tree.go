/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func invertTree(root *TreeNode) *TreeNode {
    if root == nil {
        return root
    }

    tmp := root.Right
    root.Right = root.Left
    root.Left = tmp

    invertTree(root.Left)
    invertTree(root.Right)

    return root
} 