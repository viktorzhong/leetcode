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
    public int getHeight(TreeNode root) {
        if(root == null) return 0;

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        return Math.max(left, right) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1 &&
                isBalanced(root.left) && isBalanced(root.right);
    }
}