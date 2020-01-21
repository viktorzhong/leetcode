/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    // Recursive solution
    public Node connectRecursive(Node root) {
        if(root == null || root.left == null) return root;
        
        root.left.next = root.right;
        if(root.next != null) {
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
        
        return root;
    }

    // Iterative solution
    public Node connect(Node root) {
        if(root == null) return root;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();
            int visited = 0;
            for(int i = 0;i < size; i++) {
                Node n = q.poll();
                visited++;
                
                if(visited != size) {
                    n.next = q.peek();
                }
                if(n.left != null) q.offer(n.left);
                if(n.right != null) q.offer(n.right);
            }
        }

        return root;
    }
}