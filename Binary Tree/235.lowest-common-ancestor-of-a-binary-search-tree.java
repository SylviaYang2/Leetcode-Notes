/*
 * @lc app=leetcode id=235 lang=java
 *
 * [235] Lowest Common Ancestor of a Binary Search Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // make sure val1 is smaller and val2 is bigger
        int val1 = Math.min(p.val, q.val);
        int val2 = Math.max(p.val, q.val);
        return find(root, val1, val2);
    }

    private TreeNode find(TreeNode root, int val1, int val2) {
        if (root == null) {
            return null;
        }
        if (root.val < val1) {
            return find(root.right, val1, val2);
        }
        if (root.val > val2) {
            return find(root.left, val1, val2);
        }

        // val1 <= root.val <= val2
        return root;
    }
}
// @lc code=end
