/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func build(pre []int, preStart int, preEnd int, inStart int, inPos map[int]int) *TreeNode {
    if preStart > preEnd {
        return nil
    }
    root := &TreeNode{Val: pre[preStart]}
    idx := inPos[root.Val]
    leftLen := idx - inStart

    root.Left = build(pre, preStart + 1, preStart + leftLen, inStart, inPos)
    root.Right = build(pre, preStart + leftLen + 1, preEnd, idx + 1, inPos)

    return root
}

func buildTree(pre []int, in []int) *TreeNode {
    inPos := make(map[int]int)
    for i := 0; i < len(in); i++ {
        inPos[in[i]] = i
    }
    return build(pre, 0, len(pre) - 1, 0, inPos)
}