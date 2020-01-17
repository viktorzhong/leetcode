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
    // Recursive solution
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

    // Iterative solution  非递归解法
    public boolean isSymmetricIterative(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);

        while(!stack.isEmpty()) {
            TreeNode r = stack.pop(), l = stack.pop();
            if(r == null && l == null) continue;
            if(r == null || l == null) return false;
            if(r.val != l.val) return false;

            stack.push(l.left); stack.push(r.right);
            stack.push(l.right); stack.push(r.left);
        }
        return true;
    }
}