/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func preorder(root *TreeNode, res *[]*TreeNode) {
    if root == nil {return}
    *res = append(*res, root)
    preorder(root.Left, res)
    preorder(root.Right, res)
}

func flatten(root *TreeNode)  {
    if root == nil {return}
    var res []*TreeNode

    preorder(root, &res)

    cur := root
    for i := 1; i < len(res); i++ {
        cur.Left = nil
        cur.Right = res[i]
        cur = cur.Right
    }

}