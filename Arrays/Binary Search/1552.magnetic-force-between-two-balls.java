import java.util.Arrays;

/*
 * @lc app=leetcode id=1552 lang=java
 *
 * [1552] Magnetic Force Between Two Balls
 */

// @lc code=start
class Solution {
    public int maxDistance(int[] position, int m) {
        // x: magnetic force
        // f(x): how many balls
        // target: m balls
        Arrays.sort(position);
        int left = 1, right = position[position.length - 1] - position[0];

        int ans = -1;
        // while (left <= right) {
        // int mid = left + (right - left) / 2;
        // if (countBalls(position, mid) >= m) {
        // left = mid + 1;
        // ans = mid;
        // } else {
        // right = mid - 1;
        // }
        // }
        // return ans;

        // or
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (countBalls(position, mid) >= m) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;

    }

    private int countBalls(int[] position, int force) {
        // 排序后的第一个位置一定放一个球
        int count = 1;
        int curPos = position[0];

        for (int pos : position) {
            if (pos - curPos >= force) {
                count++;
                curPos = pos;
            }
        }
        return count;
    }
}
// @lc code=end
