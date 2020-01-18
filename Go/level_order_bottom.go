/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func levelOrderBottom(root *TreeNode) [][]int {
    if root == nil {
        return [][]int{}
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

    for i, j := 0, len(res) - 1; i < j; i, j = i + 1, j - 1 {
        res[i], res[j] = res[j], res[i]
    }

    return res
}