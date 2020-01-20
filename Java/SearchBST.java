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
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null || val == root.val) return root;

        if(val < root.val) return searchBST(root.left, val);
        else return searchBST(root.right, val);
    }

    public TreeNode searchBSTIterative(TreeNode root, int val) {
        while(root != null && root.val != val) {
            if(val < root.val) root = root.left;
            else root = root.right;
        }
        return root;
    }
}