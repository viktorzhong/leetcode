/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        return isSymmetricTrees(root.left, root.right);
    }

    public boolean isSymmetricTrees(TreeNode l, TreeNode r) {
        if(l != null && r != null) {
            return l.val == r.val && isSymmetricTrees(l.left, r.right) 
                    && isSymmetricTrees(l.right, r.left);
        }

        return l == null && r == null;
    }
}