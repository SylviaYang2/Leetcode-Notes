/*
 * @lc app=leetcode id=236 lang=java
 *
 * [236] Lowest Common Ancestor of a Binary Tree
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

    // Method 1
    // private TreeNode res;

    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    // dfs(root, p, q);
    // return res;
    // }

    // private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
    // if (root == null) {
    // return false;
    // }
    // boolean lson = dfs(root.left, p, q);
    // boolean rson = dfs(root.right, p, q);
    // if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson ||
    // rson))) {
    // res = root;
    // }
    // return lson || rson || (root.val == p.val || root.val == q.val);
    // }

    // Method 2: basically the same as method 1
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        // 只要当前根节点是p和q中的任意一个，就返回（因为不能比这个更深了，再深p和q中的一个就没了）
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 左右子树都找到p和q了，那就说明p和q分别在左右两个子树上，所以此时的最近公共祖先就是root
        if (left != null && right != null) {
            return root;
        }
        // 左/右子树没有p也没有q，就返回右子树的结果
        return left != null ? left : right;
    }
}
// @lc code=end
