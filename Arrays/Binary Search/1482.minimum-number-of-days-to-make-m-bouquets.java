/*
 * @lc app=leetcode id=1482 lang=java
 *
 * [1482] Minimum Number of Days to Make m Bouquets
 */

// @lc code=start
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) {
            return -1;
        }
        // x: days to make bouquets
        // f(x): bouquets can be made within x days
        // target: m bouquets
        int left = bloomDay[0], right = bloomDay[0];
        for (int day : bloomDay) {
            left = Math.min(left, day);
            right = Math.max(right, day);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (makeBouquets(bloomDay, k, m, mid) >= m) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int makeBouquets(int[] bloomDay, int k, int m, int days) {
        int flowers = 0;
        int bouquets = 0;
        for (int i = 0; i < bloomDay.length && bouquets <= m; i++) {
            if (bloomDay[i] <= days) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }
        return bouquets;
    }
}
// @lc code=end
