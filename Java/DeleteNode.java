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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        
        if(key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if(key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;

            TreeNode leftMost = root.left;
            while(leftMost.right != null) leftMost = leftMost.right;
            leftMost.right = root.right;
            root = root.left;
        }

        return root;
    }
}