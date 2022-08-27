import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// @lc code=start
class Solution {
    // Method 1: using Priority Queue
    // public ListNode mergeKLists(ListNode[] lists) {
    // PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
    // ListNode dummy = new ListNode(-1);
    // ListNode p = dummy;

    // for (ListNode node : lists) {
    // if (node != null) {
    // queue.offer(node);
    // }
    // }

    // while (!queue.isEmpty()) {
    // ListNode cur = queue.poll();
    // p.next = cur;
    // if (cur.next != null) {
    // queue.offer(cur.next);
    // }
    // p = p.next;
    // }

    // return dummy.next;
    // }

    // Method 2: Merge lists by pairs
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int lo, int hi) {
        if (lo == hi) {
            return lists[lo];
        }

        int mid = lo + (hi - lo) / 2;
        ListNode l1 = merge(lists, lo, mid);
        ListNode l2 = merge(lists, mid + 1, hi);
        return mergeTwo(l1, l2);
    }

    private ListNode mergeTwo(ListNode list1, ListNode list2) {
        ListNode p = new ListNode(0);
        ListNode res = p;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                res.next = list1;
                list1 = list1.next;
            } else {
                res.next = list2;
                list2 = list2.next;
            }
            res = res.next;
        }
        if (list1 != null) {
            res.next = list1;
        } else if (list2 != null) {
            res.next = list2;
        }
        return p.next;
    }
}
// @lc code=end
