/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func build(post []int, postStart int, postEnd int, inStart int, inPos map[int]int) *TreeNode {
    if postStart > postEnd {
        return nil
    }
    root := &TreeNode{Val: post[postEnd]}
    idx := inPos[root.Val]
    leftLen := idx - inStart

    root.Left = build(post, postStart, postStart + leftLen - 1, inStart, inPos)
    root.Right = build(post, postStart + leftLen, postEnd - 1, idx + 1, inPos)

    return root
}

func buildTree(in []int, post []int) *TreeNode {
    inPos := make(map[int]int)
    for i := 0; i < len(in); i++ {
        inPos[in[i]] = i
    }

    return build(post, 0, len(post) - 1, 0, inPos)
}