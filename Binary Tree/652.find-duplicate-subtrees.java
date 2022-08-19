import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.text.AbstractDocument.Content;

/*
 * @lc app=leetcode id=652 lang=java
 *
 * [652] Find Duplicate Subtrees
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
    HashMap<String, Integer> map = new HashMap<>();
    LinkedList<TreeNode> res = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    private String traverse(TreeNode root) {
        if (root == null) {
            return "null";
        }
        String left = traverse(root.left);
        String right = traverse(root.right);
        String subTree = root.val + "," + left + "," + right;

        int count = map.getOrDefault(subTree, 0);
        if (count == 1) {
            res.add(root);
        }
        map.put(subTree, count + 1);

        return subTree;
    }
}
// @lc code=end
