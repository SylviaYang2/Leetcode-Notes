/*
 * @lc app=leetcode id=287 lang=java
 *
 * [287] Find the Duplicate Number
 */

// @lc code=start
class Solution {
    // method 1: slow and fast pointers
    // public int findDuplicate(int[] nums) {
    // int slow = 0, fast = 0;
    // slow = nums[slow];
    // fast = nums[nums[fast]];
    // while (slow != fast) {
    // slow = nums[slow];
    // fast = nums[nums[fast]];
    // }

    // slow = 0;
    // while (slow != fast) {
    // slow = nums[slow];
    // fast = nums[fast];
    // }

    // return slow;
    // }

    // method 2: binary search
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int left = 1, right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // the number of element that's <= mid
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }

            if (count <= mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

}
// @lc code=end
