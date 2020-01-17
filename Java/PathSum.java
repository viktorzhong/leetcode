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
	// 递归算法
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        
        if(root.left == null && root.right == null) return sum == root.val;

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        
    }

    // Iterative solution
	// 非递归算法，借助两个stack
    public boolean hasPathSumIterative(TreeNode root, int sum) {
        if(root == null) return false;

        Stack<Integer> sumStack  = new Stack<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        sumStack.push(sum);

        while(!stack.isEmpty()) {
            int s = sumStack.pop();
            TreeNode node = stack.pop();
            if(node.left == null && node.right == null && node.val == s) return true;

            if(node.left != null) {
                stack.push(node.left);
                sumStack.push(s - node.val);
            }

            if(node.right != null) {
                stack.push(node.right);
                sumStack.push(s - node.val);
            }
        }
       
        return false;
    }


}