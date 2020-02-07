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
    public int rob(TreeNode root) {
        int[] res = solve(root);
        return Math.max(res[0], res[1]);
    }

    private int[] solve(TreeNode root) {
        int[] res = new int[2];
        if(root == null) return new int[2];
        int[] left = solve(root.left);
        int[] right = solve(root.right);
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = left[0] + right[0] + root.val;
        
        return res;
    }
}