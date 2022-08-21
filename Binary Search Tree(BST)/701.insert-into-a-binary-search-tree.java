import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=701 lang=java
 *
 * [701] Insert into a Binary Search Tree
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
    // Method 1
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        }

        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        }

        return root;
    }

    // // Method 2
    // public TreeNode insertIntoBST(TreeNode root, int val) {
    // TreeNode node = new TreeNode(val);
    // if (root == null) {
    // return node;
    // }

    // TreeNode cur = root;
    // while (true) {
    // if (val < cur.val) {
    // if (cur.left == null) {
    // cur.left = node;
    // break;
    // }
    // root = cur.left;
    // } else {
    // if (cur.right == null) {
    // cur.right = node;
    // break;
    // }
    // root = cur.right;
    // }
    // }

    // return root;
    // }
}
// @lc code=end
