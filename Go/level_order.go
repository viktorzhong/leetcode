/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func levelOrder(root *TreeNode) [][]int {
    if root == nil {
        return nil
    }

    var res [][]int
    var q []*TreeNode
    q = append(q, root)

    for len(q) > 0 {
        size := len(q)
        var elem []int
        for i := 0; i < size; i++ {
            n := q[i]
            elem = append(elem, n.Val)
            if n.Left != nil {
                q = append(q, n.Left)
            }
            if n.Right != nil {
                q = append(q, n.Right)
            }
        }
        res = append(res, elem)
        q = q[size:]
    }

    return res
}