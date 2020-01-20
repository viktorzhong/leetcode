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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean left2right = true;

        while(!q.isEmpty()) {
            List<Integer> elem = new ArrayList<>();
            int size = q.size();
            for(int i = 0;i < size; i++) {
                TreeNode n = q.poll();
                elem.add(n.val);
                if(n.left != null) q.offer(n.left);
                if(n.right != null) q.offer(n.right);
            }
            if(!left2right) Collections.reverse(elem);
            res.add(elem);
            left2right = !left2right;
        }

        return res;
    }
}