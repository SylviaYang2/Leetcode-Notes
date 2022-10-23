/*
 * @lc app=leetcode id=153 lang=java
 *
 * [153] Find Minimum in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            // the [mid, right] interval is increasing, we want to
            // search on [left, mid]
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                // all numbers in [left, mid] is greater than nums[right]
                // which means that we don't need to check nums in [left, mid]
                // since none of them can be the minimum
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
// @lc code=end
