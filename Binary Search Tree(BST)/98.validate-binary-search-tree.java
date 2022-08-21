import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
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
    // method 1
    // public boolean isValidBST(TreeNode root) {
    // return isValidBST(root, null, null);
    // }

    // private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
    // if (root == null) {
    // return true;
    // }
    // if (min != null && min.val >= root.val) {
    // return false;
    // }
    // if (max != null && max.val <= root.val) {
    // return false;
    // }
    // return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    // }

    // Method 2
    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;

        return isValidBST(root.right);
    }
}
// @lc code=end
