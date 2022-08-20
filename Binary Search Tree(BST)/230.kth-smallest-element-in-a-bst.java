import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=230 lang=java
 *
 * [230] Kth Smallest Element in a BST
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
    // public int kthSmallest(TreeNode root, int k) {
    // // max Priority Queue
    // PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
    // Deque<TreeNode> q = new ArrayDeque<>();

    // q.offer(root);
    // while (!q.isEmpty()) {
    // TreeNode curr = q.poll();
    // if (pq.size() < k) {
    // pq.offer(curr.val);
    // } else if (curr.val < pq.peek()) {
    // pq.poll();
    // pq.offer(curr.val);
    // }
    // if (curr.left != null) {
    // q.offer(curr.left);
    // }
    // if (curr.right != null) {
    // q.offer(curr.right);
    // }
    // }
    // return pq.peek();
    // }

    int res = 0;
    int rank = 0;

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    private void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        traverse(root.left, k);
        rank++;
        if (rank == k) {
            res = root.val;
            return;
        }
        traverse(root.right, k);

    }
}
// @lc code=end
