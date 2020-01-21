/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func isSameTree(s *TreeNode, t *TreeNode) bool {
    if s == nil && t == nil {return true}
    if s == nil || t == nil {return false}

    return s.Val == t.Val && isSameTree(s.Left, t.Left) && isSameTree(s.Right, t.Right)
}

func isSubtree(s *TreeNode, t *TreeNode) bool {
    if t == nil {return true}
    if s == nil {return false}

    return isSameTree(s, t) || isSubtree(s.Left, t) || isSubtree(s.Right, t)
}