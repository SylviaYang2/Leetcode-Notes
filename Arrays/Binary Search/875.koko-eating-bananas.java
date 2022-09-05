/*
 * @lc app=leetcode id=875 lang=java
 *
 * [875] Koko Eating Bananas
 */

// @lc code=start
class Solution {
    // x: speed of eating (banana/hour)
    // f(x): time of eating (hour)
    // target: h
    public int minEatingSpeed(int[] piles, int h) {
        int maxVal = 1;
        for (int pile : piles) {
            maxVal = Math.max(maxVal, pile);
        }
        // left & right is the min & max speed of eating
        int left = 1, right = maxVal;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (eatingHours(piles, mid) == h) {
                right = mid;
            } else if (eatingHours(piles, mid) < h) {
                right = mid;
            } else if (eatingHours(piles, mid) > h) {
                left = mid + 1;
            }
        }
        return left;
    }

    private int eatingHours(int[] piles, int x) {
        int hours = 0;
        for (int pile : piles) {
            hours += pile / x;
            if (pile % x != 0) {
                hours++;
            }
        }
        return hours;
    }
}
// @lc code=end
