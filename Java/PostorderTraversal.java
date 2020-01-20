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

    public List<Integer> postorderIterative(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            root = stack.pop();
            res.addFirst(root.val);
            if(root.left != null) stack.push(root.left);
            if(root.right != null) stack.push(root.right);
        }

        return res;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        List<Integer> left = postorderTraversal(root.left);
        List<Integer> right = postorderTraversal(root.right);
        if(left != null && left.size() > 0) res.addAll(left);
        if(right != null && right.size() > 0) res.addAll(right);
        res.add(root.val);

        return res;
    }
}