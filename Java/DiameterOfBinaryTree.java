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
    private int dfs(TreeNode root, int[] max) {
        if(root == null) return 0;
        int left = dfs(root.left, max);
        int right = dfs(root.right, max);
        int cur = left + right;
        max[0] = Math.max(max[0], cur);
        
        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = new int[]{0};
        dfs(root, max);

        return max[0];
    }
}