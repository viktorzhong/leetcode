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
    public boolean equals(TreeNode s, TreeNode t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false; 

        return s.val == t.val && equals(s.left, t.left) && equals(s.right, t.right);
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(t == null) return true;
        if(s == null) return false;

        return equals(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }
}