/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func getHeight(root *TreeNode) int {
    if root == nil {
        return 0
    }
    left := getHeight(root.Left)
    right := getHeight(root.Right)

    if left > right {
        return left + 1
    }
    return right + 1
}

func abs(n int) int {
    if n < 0 {
        return -n;
    }
    return n;
}

func isBalanced(root *TreeNode) bool {
    if root == nil {
        return true
    }

    return abs(getHeight(root.Left) - getHeight(root.Right)) <= 1 &&
            isBalanced(root.Left) && isBalanced(root.Right)
}