/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func toBST(nums []int, start, end int) *TreeNode {
    if start > end {
        return nil
    }
    mid := start + (end - start) / 2
    root := &TreeNode{Val: nums[mid]}
    
    root.Left = toBST(nums, start, mid - 1)
    root.Right = toBST(nums, mid + 1, end)

    return root
}

func sortedArrayToBST(nums []int) *TreeNode {
    if nums == nil || len(nums) == 0 {
        return nil
    }

    return toBST(nums, 0, len(nums) - 1)
}