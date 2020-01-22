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
    public int dfs(TreeNode root, int sum) {
        if(root == null) return sum;
        int cur = dfs(root.right, sum);
        root.val += cur;
        return dfs(root.left, root.val);
    }

    public TreeNode convertBST(TreeNode root) {
        dfs(root, 0);
        return root;
    }
}