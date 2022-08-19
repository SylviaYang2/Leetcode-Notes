/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
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

// Method 1
// class Solution {
// HashMap<Integer, Integer> valToIndex = new HashMap<>();
// int postIndex;

// public TreeNode buildTree(int[] inorder, int[] postorder) {
// for (int i = 0; i < inorder.length; i++) {
// valToIndex.put(inorder[i], i);
// }

// postIndex = postorder.length - 1;

// return build(inorder, 0, inorder.length - 1,
// postorder);
// }

// private TreeNode build(int[] inorder, int inStart, int inEnd, int[]
// postorder) {
// // Base case
// if (inStart > inEnd) {
// return null;
// }

// int rootVal = postorder[postIndex];
// postIndex -= 1;
// int rootIndex = valToIndex.get(rootVal);

// TreeNode root = new TreeNode(rootVal);

// int leftSize = rootIndex - inStart;

// root.right = build(inorder, rootIndex + 1, inEnd, postorder);
// root.left = build(inorder, inStart, rootIndex - 1, postorder);

// return root;

// }
// }

// Method 2
class Solution {
    HashMap<Integer, Integer> valToIndex = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }

        return build(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        // Base case
        // if (inStart > inEnd) {
        if (postStart > postEnd) {
            return null;
        }

        int rootVal = postorder[postEnd];
        int rootIndex = valToIndex.get(rootVal);

        TreeNode root = new TreeNode(rootVal);

        int leftSize = rootIndex - inStart;

        root.left = build(inorder, inStart, rootIndex - 1, postorder, postStart, postStart + leftSize - 1);
        root.right = build(inorder, rootIndex + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);

        return root;

    }
}
// @lc code=end
