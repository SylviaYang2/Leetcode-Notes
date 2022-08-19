import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import javax.management.Query;
import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=297 lang=java
 *
 * [297] Serialize and Deserialize Binary Tree
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

// Method 1 - DFS
// public class Codec {

// // Encodes a tree to a single string.
// public String serialize(TreeNode root) {
// if (root == null) {
// return "null";
// }
// String left = serialize(root.left);
// String right = serialize(root.right);
// return root.val + "," + left + "," + right;
// }

// // Decodes your encoded data to tree.
// public TreeNode deserialize(String data) {
// String[] splitData = data.split(",");
// Deque<String> nodes = new LinkedList<>(Arrays.asList(splitData));
// return buildTree(nodes);
// }

// private TreeNode buildTree(Deque<String> nodes) {
// String val = nodes.removeFirst();
// if (val.equals("null")) {
// return null;
// }
// TreeNode node = new TreeNode(Integer.parseInt(val));
// node.left = buildTree(nodes);
// node.right = buildTree(nodes);
// return node;
// }
// }

// Method 2: BFS
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr == null) {
                sb.append("null,");
            } else {
                sb.append(curr.val + ",");
                q.offer(curr.left);
                q.offer(curr.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        String[] splitData = data.split(",");
        Deque<String> nodes = new LinkedList<>(Arrays.asList(splitData));
        String val = nodes.poll();
        TreeNode root = new TreeNode(Integer.parseInt(val));
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            String left = nodes.poll();
            if (!left.equals("null")) {
                node.left = new TreeNode(Integer.parseInt(left));
                queue.offer(node.left);
            } else {
                node.left = null;
            }

            String right = nodes.poll();
            if (!right.equals("null")) {
                node.right = new TreeNode(Integer.parseInt(right));
                queue.offer(node.right);
            } else {
                node.right = null;
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end
