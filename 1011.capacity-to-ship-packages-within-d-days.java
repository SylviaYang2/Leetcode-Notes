/*
 * @lc app=leetcode id=1011 lang=java
 *
 * [1011] Capacity To Ship Packages Within D Days
 */

// @lc code=start
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // x: speed of loading (weight / day)
        // f(x): how many days
        // target: days
        int left = 0, right = 1;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (shipDays(weights, mid) == days) {
                right = mid;
            } else if (shipDays(weights, mid) < days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private int shipDays(int[] weights, int x) {
        int days = 0;
        for (int i = 0; i < weights.length;) {
            int max = x;
            while (i < weights.length) {
                if (weights[i] > max) {
                    break;
                } else {
                    max -= weights[i];
                }
                i++;
            }
            days++;
        }
        return days;
    }
}
// @lc code=end
