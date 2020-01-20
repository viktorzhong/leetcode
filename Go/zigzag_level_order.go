/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func reverse(elem []int) []int {
    for i,j := 0, len(elem) - 1; i < j; i,j = i + 1, j - 1 {
        elem[i], elem[j] = elem[j], elem[i]
    }
    return elem
}

func zigzagLevelOrder(root *TreeNode) [][]int {
    if root == nil {
        return nil
    }
    res := [][]int{}
    q := []*TreeNode{}
    q = append(q, root)
    left2right := true

    for len(q) > 0 {
        elem := []int{}
        size := len(q)

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
        if !left2right {
            elem = reverse(elem)
        }
        res = append(res, elem)
        left2right = !left2right
        q = q[size:]
    }
    return res
}