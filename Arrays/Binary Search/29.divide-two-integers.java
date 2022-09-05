/*
 * @lc app=leetcode id=29 lang=java
 *
 * [29] Divide Two Integers
 */

// @lc code=start
class Solution {
    public int divide(int dividend, int divisor) {
        // Base cases
        // 考虑被除数为最小值的情况
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            } else if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }

        // 考虑除数为最小值的情况
        if (divisor == Integer.MIN_VALUE) {
            if (dividend == Integer.MIN_VALUE) {
                return 1;
            }
            return 0;
        }

        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            return -dividend;
        }

        boolean isNeg = false;
        long x = dividend, y = divisor;
        if (x > 0 && y < 0 || x < 0 && y > 0) {
            isNeg = true;
        }

        if (Math.abs(x) == Math.abs(y)) {
            if (isNeg) {
                return -1;
            } else {
                return 1;
            }
        }

        if (x < 0)
            x = -x;
        if (y < 0)
            y = -y;

        // 由于x/y的结果肯定在[0,x]范围内，所以对x使用二分法
        long left = 0, right = x;
        while (left < right) {
            // long mid = left + right + 1 >> 1;

            // if (mul(mid, y) <= x) {
            // left = mid;
            // } else {
            // right = mid - 1;
            // }
            long mid = left + ((right - left) >> 1);

            if (mul(mid, y) <= x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // return isNeg ? (int) -(right) : (int) (right);
        return isNeg ? (int) -(right - 1) : (int) (right - 1);
    }

    private long mul(long x, long y) {
        long res = 0;
        while (y > 0) {
            // if the divisor is an odd number
            if ((y & 1) == 1) {
                res += x;
            }
            y >>= 1;
            x += x;
        }
        return res;
    }
}
// @lc code=end
