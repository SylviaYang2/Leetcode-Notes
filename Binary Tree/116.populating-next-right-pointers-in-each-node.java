/*
 * @lc app=leetcode id=116 lang=java
 *
 * [116] Populating Next Right Pointers in Each Node
 */

// @lc code=start
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
    // Solution 1 - recursion 
    // public Node connect(Node root) {
    //     if (root == null) {
    //         return null;
    //     }
    //     traverse(root.left, root.right);
    //     return root;
    // }

    // private void traverse(Node node1, Node node2) {
    //     if (node1 == null || node2 == null) {
    //         return;
    //     }
    //     node1.next = node2;

    //     traverse(node1.left, node1.right);
    //     traverse(node1.right, node2.left);
    //     traverse(node2.left, node2.right);
    // }

    // Solution 2 - BFS
    // public Node connect(Node root) {
    //     if (root == null) {
    //         return null;
    //     }
    //     Node head = root;
    //     while (head != null) {
    //         Node curr = head;
    //         while (curr != null) {
    //             if (curr.left != null) {
    //                 curr.left.next = curr.right;
    //             }
    //             if (curr.right != null && curr.next != null) {
    //                 curr.right.next = curr.next.left;
    //             }
    //            // iterate through all nodes in the same level
    //             curr = curr.next;
    //         }
    //          // move onto the next level of the tree
    //         head = head.left;
    //     }
    //     return root;
    // }

    // Solution 3 - recursion
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        
        connect(root.left);
        connect(root.right);

        Node left = root.left;
        Node right = root.right;

        // Depth by depth
        while (left != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
        return root;
    }
}
// @lc code=end

