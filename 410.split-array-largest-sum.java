/*
 * @lc app=leetcode id=410 lang=java
 *
 * [410] Split Array Largest Sum
 */

// @lc code=start
class Solution {
    public int splitArray(int[] nums, int m) {
        // x: speed of loading (weight / day) == nums[i] here
        // f(x): how many days
        // target: days == m here
        int left = 0, right = 1;
        for (int n : nums) {
            left = Math.max(left, n);
            right += n;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (f(nums, mid) <= m) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int f(int[] nums, int x) {
        int sum = 0;
        for (int i = 0; i < nums.length;) {
            int cap = x;
            while (i < nums.length) {
                if (nums[i] > cap) {
                    break;
                } else {
                    cap -= nums[i];
                }
                i++;
            }
            sum++;
        }
        return sum;
    }
}
// @lc code=end
