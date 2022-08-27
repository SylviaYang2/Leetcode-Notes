/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
 */

// @lc code=start
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
class Solution {

    // Method 1
    // public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    // ListNode dummy = new ListNode(0);
    // ListNode p = dummy;
    // while (list1 != null && list2 != null) {
    // if (list1.val < list2.val) {
    // p.next = list1;
    // list1 = list1.next;
    // } else {
    // p.next = list2;
    // list2 = list2.next;
    // }
    // p = p.next;
    // }

    // if (list1 != null) {
    // p.next = list1;
    // }
    // if (list2 != null) {
    // p.next = list2;
    // }
    // return dummy.next;
    // }

    // Method 2: recursion
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
// @lc code=end
