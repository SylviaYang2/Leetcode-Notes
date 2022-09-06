/*
 * @lc app=leetcode id=69 lang=java
 *
 * [69] Sqrt(x)
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        // corner cases
        if (x == 0) {
            return 0;
        }

        if (x == 1) {
            return 1;
        }

        int left = 1, right = x;
        int ans = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid) { // prevent overflow
                left = mid + 1;
                ans = mid;
            } else {
                right = mid;
            }
        }
        return ans;
    }
}
// @lc code=end
