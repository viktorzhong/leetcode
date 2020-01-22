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
    private void preorder(TreeNode root, List<TreeNode> list) {
        if(root == null) return;
        list.add(root);
        preorder(root.left, list);
        preorder(root.right, list);
    }

    public void flatten(TreeNode root) {
        if(root == null) return;
        List<TreeNode> res = new ArrayList<>();
        preorder(root, res);

        for(int i = 0; i < res.size(); i++) {
            TreeNode cur = res.get(i);
            cur.left = null;
            cur.right = i == res.size() - 1? null : res.get(i + 1);
        }

    }
}