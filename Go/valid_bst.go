/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func isValidBST(root *TreeNode) bool {
    return isValidBSTWithBound(root, nil, nil)
}

func isValidBSTWithBound(root, lower, upper *TreeNode) bool {
    if root == nil {
        return true
    }
    if lower != nil && lower.Val >= root.Val {
        return false
    }
    if upper != nil && upper.Val <= root.Val {
        return false
    }

    return isValidBSTWithBound(root.Left, lower, root) && isValidBSTWithBound(root.Right, root, upper)
}