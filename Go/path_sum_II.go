/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func pathSum(root *TreeNode, sum int) [][]int {
    var res [][]int
    var elem []int

    path(root, sum, &elem, &res)

    return res
}

func path(root *TreeNode, sum int, elem *[]int, res *[][]int) {
    if root == nil {
        return
    }
    *elem = append(*elem, root.Val)
    if root.Left == nil && root.Right == nil && sum == root.Val {
        r := append([]int{}, *elem...)
        *res = append(*res, r)
    }

    path(root.Left, sum - root.Val, elem, res)
    path(root.Right, sum - root.Val, elem, res)

    *elem = (*elem)[:len(*elem) - 1]
}