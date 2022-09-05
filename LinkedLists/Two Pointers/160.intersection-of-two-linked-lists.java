/*
 * @lc app=leetcode id=160 lang=java
 *
 * [160] Intersection of Two Linked Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Method 1
        // ListNode p1 = headA;
        // ListNode p2 = headB;
        // while (p1 != p2) {
        // if (p1 == null) {
        // p1 = headB;
        // } else {
        // p1 = p1.next;
        // }

        // if (p2 == null) {
        // p2 = headA;
        // } else {
        // p2 = p2.next;
        // }
        // }
        // return p1;

        // Method 2
        int len1 = 0, len2 = 0;
        for (ListNode p1 = headA; p1 != null; p1 = p1.next) {
            len1++;
        }
        for (ListNode p2 = headB; p2 != null; p2 = p2.next) {
            len2++;
        }

        ListNode p1 = headA, p2 = headB;
        if (len1 > len2) {
            for (int i = 0; i < len1 - len2; i++) {
                p1 = p1.next;
            }
        } else {
            for (int i = 0; i < len2 - len1; i++) {
                p2 = p2.next;
            }
        }

        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }
}
// @lc code=end
