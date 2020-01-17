/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func isSymmetric(root *TreeNode) bool {
    if root == nil {
        return true
    }

    return isSymmetricTrees(root.Left, root.Right)
}

func isSymmetricTrees(l *TreeNode, r *TreeNode) bool {
    if l != nil && r != nil {
        return l.Val == r.Val && isSymmetricTrees(l.Left, r.Right) && isSymmetricTrees(l.Right, r.Left)
    }

    return l == nil && r == nil
}