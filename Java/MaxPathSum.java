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
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        int[] max = new int[]{Integer.MIN_VALUE};

        dfs(root, max);
        return max[0];
    }

    private int dfs(TreeNode root, int[] max) {
        int left = root.left != null ? Math.max(dfs(root.left, max), 0): 0;
        int right = root.right != null ? Math.max(dfs(root.right, max), 0): 0;
        int cur = root.val + left + right;
        max[0] = Math.max(cur, max[0]);

        return root.val + Math.max(left, right);
    }
}