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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            List<Integer> elem = new ArrayList<>();
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode n = q.poll();
                elem.add(n.val);
                if(n.left != null) q.offer(n.left);
                if(n.right != null) q.offer(n.right);
            }
            res.add(elem);
        }

        for(int i = 0; i < res.size() / 2; i++) {
            int j = res.size() - 1 - i;
            List<Integer> tmp = res.get(j);
            res.set(j, res.get(i));
            res.set(i, tmp);
        }

        return res;
    }
}