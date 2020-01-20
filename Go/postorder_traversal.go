/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func postorderTraversal(root *TreeNode) []int {
    if root == nil {
        return []int{}
    }
    
    var stack []*TreeNode
    var res []int 
    l := list.New()
    stack = append(stack, root)

    for len(stack) > 0 {
        n := stack[len(stack) - 1]
        l.PushFront(n.Val)
        stack = stack[:len(stack) - 1]
        if n.Left != nil {
            stack = append(stack, n.Left)
        }
        if n.Right != nil {
            stack = append(stack, n.Right)
        }
    }

    for p := l.Front(); p != nil; p = p.Next() {
        res = append(res, p.Value.(int))
    }

    return res
}