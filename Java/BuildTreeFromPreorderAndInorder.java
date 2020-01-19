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
    private TreeNode buildTree(
    int[] pre, int preStart, int preEnd,
    int inStart, Map<Integer, Integer> inPos) {

    if (preStart > preEnd) return null;
    TreeNode root = new TreeNode(pre[preStart]);
    int idx = inPos.get(root.val);
    int leftLen = idx - inStart;

    root.left = buildTree(pre, preStart + 1, preStart + leftLen, inStart, inPos);
    root.right = buildTree(pre, preStart + leftLen + 1, preEnd, idx + 1, inPos);

    return root;
  }

  // Time: O(n), Space: O(n)
  public TreeNode buildTree(int[] pre, int[] in) {
    Map<Integer, Integer> inPos = new HashMap<>();
    for (int i = 0; i < in.length; ++i)
      inPos.put(in[i], i);
    return buildTree(pre, 0, pre.length-1, 0, inPos);
  }
}