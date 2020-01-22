/**
 * Definition for TreeNode.
 * type TreeNode struct {
 *     Val int
 *     Left *ListNode
 *     Right *ListNode
 * }
 */
 func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
     if root == nil {return nil}
     if root == p || root == q {return root}

     left := lowestCommonAncestor(root.Left, p, q)
     right := lowestCommonAncestor(root.Right, p, q)

     if left != nil && right != nil {
         return root
     }
     if left == nil {
         return right
     }
     if right == nil {
         return left
     }
     return nil
}