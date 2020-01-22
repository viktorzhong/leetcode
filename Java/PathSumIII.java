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
    public int pathFrom(TreeNode root, int sum) {
        if(root == null) return 0;
        int cnt = 0;
        if(root.val == sum) cnt++;
        int left = pathFrom(root.left, sum - root.val);
        int right = pathFrom(root.right, sum - root.val);

        cnt += (left + right);

        return cnt;
    }

    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;

        return pathFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
}