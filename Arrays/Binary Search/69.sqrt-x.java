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

            // 如果这个整数的平方 恰好等于 输入整数，那么我们就找到了这个整数； 如果这个整数的平方 严格大于 输入整数，那么这个整数肯定不是我们要找的那个数；
            // 如果这个整数的平方 严格小于 输入整数，那么这个整数 可能 是我们要找的那个数（重点理解这句话）。
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
