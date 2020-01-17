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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        path(root, sum, new ArrayList<Integer>(), res);
        return res;
    }

    private void path(TreeNode root, int sum, List<Integer> vals, List<List<Integer>> res) {
        if(root == null) return;
        vals.add(root.val);
        if(root.left == null && root.right == null && root.val == sum) {
            res.add(new ArrayList<>(vals));
        }
        
        path(root.left, sum - root.val, vals, res);
        path(root.right, sum - root.val, vals, res);

        vals.remove(vals.size() - 1);
    }
}