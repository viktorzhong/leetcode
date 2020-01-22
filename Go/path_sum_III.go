/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func pathFrom(root *TreeNode, sum int) int {
    if root == nil {return 0}
    var cnt int
    if root.Val == sum {cnt += 1}

    left := pathFrom(root.Left, sum - root.Val)
    right := pathFrom(root.Right, sum - root.Val)

    return cnt + left + right
}

func pathSum(root *TreeNode, sum int) int {
    if root == nil {return 0}
    return pathFrom(root, sum) + pathSum(root.Left, sum) + pathSum(root.Right, sum)
}