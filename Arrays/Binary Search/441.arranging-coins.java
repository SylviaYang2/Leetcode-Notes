/*
 * @lc app=leetcode id=441 lang=java
 *
 * [441] Arranging Coins
 */

// @lc code=start
class Solution {
    public int arrangeCoins(int n) {
        if (n == 1) {
            return 1;
        }
        // x: levels
        // f(x): how many coins on x levels in total
        // target: n coins
        // 套右侧边界搜索模版
        long left = 1, right = n; // 左闭右开

        while (left < right) {
            long mid = left + (right - left) / 2;
            long sum = (mid * (mid + 1)) / 2;

            if (sum <= n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (left * (left + 1) / 2 == n) { // 第left行完整
            return (int) left;
        }

        return (int) left - 1; // 第left行not完整
    }
}
// @lc code=end
