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
    public boolean isValidBST(TreeNode root) {
        return isValidBSTWithBound(root, null, null);
    }

    public boolean isValidBSTWithBound(TreeNode root, TreeNode lower, TreeNode upper) {
        if(root == null) return true;
        if(lower != null && lower.val >= root.val) return false;
        if(upper != null && upper.val <= root.val) return false;

        return isValidBSTWithBound(root.left, lower, root) && isValidBSTWithBound(root.right, root, upper);
    } 
}