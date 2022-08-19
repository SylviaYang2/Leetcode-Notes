/*
 * @lc app=leetcode id=889 lang=java
 *
 * [889] Construct Binary Tree from Preorder and Postorder Traversal
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
    HashMap<Integer, Integer> valToIndex = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            valToIndex.put(postorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
        // Base case
        if (preStart > preEnd) {
            // if (postStart > postEnd) {
            return null;
        }

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        // 当长度为1时,可以直接返回该节点作为根节点
        if (preStart == preEnd) {
            return root;
        }

        int leftrootVal = preorder[preStart + 1];
        int leftrootIndex = valToIndex.get(leftrootVal);

        int leftSize = leftrootIndex - postStart + 1;

        root.left = build(preorder, preStart + 1, preStart + leftSize, postorder, postStart, leftrootIndex);
        root.right = build(preorder, preStart + leftSize + 1, preEnd, postorder, leftrootIndex + 1, postEnd - 1);

        return root;

    }

}
// @lc code=end
