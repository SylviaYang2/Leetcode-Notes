/*
 * @lc app=leetcode id=1094 lang=java
 *
 * [1094] Car Pooling
 */

// @lc code=start
class Difference {
    int diff[];

    public Difference(int[] nums) {
        diff = new int[nums.length];
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    public void increment(int i, int j, int val) {
        diff[i] += val;
        if (j + 1 < diff.length) {
            diff[j + 1] -= val;
        }
    }

    public int[] result() {
        int[] res = new int[diff.length];
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i] = diff[i] + res[i - 1];
        }
        return res;
    }
}

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] nums = new int[1001];
        Difference df = new Difference(nums);

        for (int[] trip : trips) {
            int val = trip[0];
            int i = trip[1];
            // 第 trip[2] 站乘客已经下车，
            // 即乘客在车上的区间是 [trip[1], trip[2] - 1]
            int j = trip[2] - 1;
            df.increment(i, j, val);
        }

        int[] res = df.result();

        for (int i = 0; i < res.length; i++) {
            if (res[i] > capacity) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
