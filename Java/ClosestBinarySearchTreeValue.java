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
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        while(root != null) {
            double distance = Math.abs(root.val - target);
            if(distance <= 0.5) return root.val;
            if(distance < Math.abs(target - res)) res = root.val;
            root = root.val > target ? root.left : root.right;
        }
        return res;
    }
}