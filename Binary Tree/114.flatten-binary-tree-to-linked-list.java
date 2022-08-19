/*
 * @lc app=leetcode id=114 lang=java
 *
 * [114] Flatten Binary Tree to Linked List
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    // // Solution 1
    // public void flatten(TreeNode root) {
    // TreeNode curr = root;
    // while (curr != null) {
    // if (curr.left != null) { // post-order traversal
    // TreeNode pre = curr.left; // let pre point to curr's left subtree
    // while (pre.right != null) { // find the rightmost node of the left subtree
    // pre = pre.right;
    // }
    // pre.right = curr.right; // let curr.right be the right subtree of the
    // rightmost node found above
    // curr.right = curr.left; // let the left portion be the right subtree of curr
    // curr.left = null; // set the original left subtree be null
    // }
    // curr = curr.right; // move on to the next node
    // }
    // }

    // Solution 2
    // Time Complexity: O(N*H) where H is the height of the tree as the while loop
    // can only go as low as the height of the tree
    // best: O(nlogn);
    // worst: O(n^2), when all nodes are at the left of the tree
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        // flatten the left and right subtrees
        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.right = left;
        root.left = null;

        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }
}
// @lc code=end
