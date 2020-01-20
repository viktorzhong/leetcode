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
    public TreeNode buildTree(int[] post, int postStart, int postEnd, 
            int inStart, Map<Integer, Integer> inPos) {

        if(postStart > postEnd) return null;
        TreeNode root = new TreeNode(post[postEnd]);
        int idx = inPos.get(root.val);
        int leftLen = idx - inStart;

        root.left = buildTree(post, postStart, postStart + leftLen - 1, inStart, inPos);
        root.right = buildTree(post, postStart + leftLen, postEnd - 1, idx + 1, inPos);

        return root;
    }

    public TreeNode buildTree(int[] in, int[] post) {
        Map<Integer, Integer> inPos = new HashMap<>();
        for(int i = 0; i < in.length; i++) {
            inPos.put(in[i], i);
        }

        return buildTree(post, 0, post.length - 1, 0, inPos);
    }
}